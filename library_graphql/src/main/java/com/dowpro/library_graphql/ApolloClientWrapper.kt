package com.dowpro.library_graphql

import com.apollographql.apollo3.ApolloClient
import com.apollographql.apollo3.api.*
import com.apollographql.apollo3.network.okHttpClient
import okhttp3.OkHttpClient
import com.apollographql.apollo3.cache.normalized.FetchPolicy
import com.apollographql.apollo3.cache.normalized.fetchPolicy
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.withContext
import okhttp3.Headers
import okhttp3.Interceptor
import okhttp3.logging.HttpLoggingInterceptor

data class GraphQLConfiguration(val serverUrl: String, val okHttpClient: OkHttpClient)

data class GraphQLReply<T>(
    val data: T?,
    val errors: List<GraphQLError> = emptyList(),
    val throwable: Throwable? = null
) {
    val hasErrors = errors.isNotEmpty()
    val hasException = throwable != null
    val hasData = data != null
    val success = hasData && !hasErrors && !hasException
}

data class GraphQLError(private val error: Error) {
    val message: String = error.message
    val locations: List<Error.Location> = error.locations ?: emptyList()
    val type: String? = error.extensions?.get("classification") as? String
}

fun <T: Operation.Data> ApolloResponse<T>.toGraphQLReply(): GraphQLReply<T> {
    val graphQLErrors: List<GraphQLError> = this.errors?.let { localErrors ->
        MutableList(localErrors.size) { counter ->
            GraphQLError(localErrors[counter])
        }
    }?: emptyList()

    return GraphQLReply(this.data, graphQLErrors)
}

class ApolloClientWrapper(configuration: GraphQLConfiguration) {
    companion object {
        fun newInstance(configuration: GraphQLConfiguration) = ApolloClientWrapper(configuration)
    }

    private val apolloClient =  ApolloClient.Builder()
        .serverUrl(configuration.serverUrl)
        .okHttpClient(configuration.okHttpClient).build()

    suspend fun <D : Query.Data> query(query: Query<D>): GraphQLReply<D> =
        apolloClient.query(query).fetchPolicy(FetchPolicy.NetworkFirst).execute().toGraphQLReply()

    suspend fun <D : Mutation.Data> mutate(mutation: Mutation<D>): GraphQLReply<D> =
        apolloClient.mutation(mutation).fetchPolicy(FetchPolicy.NetworkFirst).execute().toGraphQLReply()
}

fun <T> Throwable.toGraphQLReply(): GraphQLReply<T> = GraphQLReply(data = null, throwable = this)

class GraphQLClient(configuration: GraphQLConfiguration, val apolloClientWrapper: ApolloClientWrapper) {
    suspend fun <D : Query.Data> query(query: Query<D>, code: (suspend (GraphQLReply<D>) -> Unit)? = null): GraphQLReply<D> =
        executeCall(suspend { apolloClientWrapper.query(query)}, code)

    suspend fun <D : Mutation.Data> mutate(mutation: Mutation<D>, code: (suspend (GraphQLReply<D>) -> Unit)?): GraphQLReply<D> =
        executeCall(suspend { apolloClientWrapper.mutate(mutation)}, code)

    private suspend fun <D: Operation.Data> executeCall(
        callCode: suspend () -> GraphQLReply<D>,
        code: (suspend (GraphQLReply<D>) -> Unit)?
    ): GraphQLReply<D> {
        return withContext(IO) {
            try {
                val response = callCode.invoke()
                withContext(Main) {
                    code?.invoke(response)
                    response
                }
            } catch (throwable: Throwable) {
                withContext(Main) {
                    val reply : GraphQLReply<D> = throwable.toGraphQLReply()
                    code?.invoke(reply)
                    reply
                }
            }
        }
    }
}

interface GraphQLClientProvider {
    fun getGraphQLClient(): GraphQLClient
    fun setGraphQLConfiguration(serverUrl: String, headers: Headers)
}

class GraphQLClientProviderImpl(
    serverUrl: String,
    headers: Headers,
    private val tokenContainer: TokenContainer,
    private val refreshHandler: TokenRefreshHandler
): GraphQLClientProvider {
    private var currentServerUrl: String = serverUrl
    private var currentHeaders: Headers = headers
    private var currentGraphQLClient: GraphQLClient = GraphQLClient(
        configuration = getGraphQLConfiguration(),
        apolloClientWrapper = ApolloClientWrapper(configuration = getGraphQLConfiguration())
    )
    override fun getGraphQLClient(): GraphQLClient = currentGraphQLClient

    override fun setGraphQLConfiguration(serverUrl: String, headers: Headers) {
        if (serverUrl != currentServerUrl || headers != currentHeaders) {
            currentServerUrl = serverUrl
            currentHeaders = headers
            currentGraphQLClient = GraphQLClient(
                configuration = getGraphQLConfiguration(),
                apolloClientWrapper = ApolloClientWrapper(configuration = getGraphQLConfiguration()))
        }
    }

    private fun getGraphQLConfiguration(): GraphQLConfiguration {
        val client = OkHttpClient.Builder().run {
            addInterceptor(GraphQLAuthorisationInterceptor(tokenContainer, refreshHandler))
            authenticator(GraphQLRefreshTokenAuthenticator(tokenContainer, refreshHandler))
            addInterceptor(createLoggingInterceptor())
        }.build()
        return GraphQLConfiguration(currentServerUrl, client)
    }

    private fun createLoggingInterceptor(): Interceptor = HttpLoggingInterceptor().apply {
        setLevel(HttpLoggingInterceptor.Level.BODY)
        redactHeader(TokenContainer.HEADER_NAME_AUTH)
    }
}