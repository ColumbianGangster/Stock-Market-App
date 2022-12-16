package com.dowpro.library_graphql

import com.auth0.jwt.JWT
import com.auth0.jwt.interfaces.DecodedJWT
import kotlinx.coroutines.runBlocking
import okhttp3.*
import java.time.Instant
import java.time.temporal.ChronoUnit

// https://github.com/auth0/java-jwt
class JsonWebToken(encodedString: String) {
    private val decodedToken: DecodedJWT = JWT.decode(encodedString)

    fun isActive(leewayInSeconds: Long): Boolean {
        val expiresAt = decodedToken.expiresAt?.toInstant() ?: return true
        val now = Instant.now()

        return expiresAt.isAfter(now.minus(leewayInSeconds, ChronoUnit.SECONDS))
    }

    fun getToken(): String = decodedToken.token
}

class TokenContainer {
    companion object {
        const val HEADER_NAME_AUTH = "Authorization"
        const val TOKEN_TYPE = "Bearer"
        const val EMPTY_TOKEN = "e30.e30"
        const val TOKEN_LEEWAY: Long = 30
    }

    private var _token: JsonWebToken = JsonWebToken(EMPTY_TOKEN)
    fun setToken(token: String) {
        _token = JsonWebToken(token)
    }

    fun getToken() = _token
}

interface TokenRefreshHandler {
    suspend fun refreshToken()
}

class GraphQLAuthorisationInterceptor(private val tokenContainer: TokenContainer, private val tokenRefreshHandler: TokenRefreshHandler):
    Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response = runBlocking {
        val currentToken = tokenContainer.getToken()
        if(!currentToken.isActive(TokenContainer.TOKEN_LEEWAY)) {
            tokenRefreshHandler.refreshToken()
        }
        val token = tokenContainer.getToken()
        val authRequestBuilder = chain.request().newBuilder()
        authRequestBuilder.addHeader(TokenContainer.HEADER_NAME_AUTH, "${TokenContainer.TOKEN_TYPE} ${token.getToken()}")
        return@runBlocking chain.proceed(authRequestBuilder.build())
    }
}

class GraphQLRefreshTokenAuthenticator(
    private val tokenContainer: TokenContainer,
    private val refreshHandler: TokenRefreshHandler
): Authenticator {
    override fun authenticate(route: Route?, response: Response): Request? = runBlocking {
        val authHeader = response.request.header(TokenContainer.HEADER_NAME_AUTH) ?: return@runBlocking null
        val authTokenEncoded = authHeader.replace("${TokenContainer.TOKEN_TYPE}", "")
        val token = JsonWebToken(authTokenEncoded)
        if (token.isActive(TokenContainer.TOKEN_LEEWAY)) {
            return@runBlocking null // The token has not expired, give up
        }
        refreshHandler.refreshToken()
        val newToken = tokenContainer.getToken().getToken()
        return@runBlocking response.request.newBuilder().addHeader(TokenContainer.HEADER_NAME_AUTH, "${TokenContainer.TOKEN_TYPE} $newToken").build()
    }
}

