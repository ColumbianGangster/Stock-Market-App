package com.dowpro.marketapp.di

import android.content.Context
import com.dowpro.feature_crypto.data.PokemonRepository
import com.dowpro.feature_crypto.data.PokemonRepositoryImpl
import com.dowpro.library_core.data.DefaultDispatchers
import com.dowpro.library_core.data.DispatcherProvider
import com.dowpro.library_graphql.GraphQLClientProvider
import com.dowpro.library_graphql.GraphQLClientProviderImpl
import com.dowpro.library_graphql.TokenContainer
import com.dowpro.library_graphql.TokenRefreshHandler
import com.dowpro.library_network.*
import com.dowpro.library_network.repos.StockRepository
import com.dowpro.library_network.repos.StockRepositoryImpl
import com.dowpro.library_network.services.StockService
import com.dowpro.library_network.storage.EncryptedFileRepository
import com.dowpro.library_network.storage.StorageRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.Headers
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

// https://www.zacsweers.dev/dagger-party-tricks-private-dependencies/



@Module
@InstallIn(SingletonComponent::class)
class DataModule {

    @Provides
    fun provideBaseUrl() = Constants.BASE_URL

    @Singleton
    @Provides
    fun provideOkHttpClient() = if (BuildConfig.DEBUG) {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .build()
    } else {
        OkHttpClient
            .Builder()
            .build()
    }

    @Singleton
    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient, BASE_URL: String): Retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(BASE_URL)
        .client(okHttpClient)
        .build()

    @Provides
    @Singleton
    fun provideStockService(retrofit: Retrofit): StockService =
        retrofit.create(StockService::class.java)

    @Provides
    @Singleton
    fun provideDispatcherProvider(): DispatcherProvider = DefaultDispatchers()

    @Provides
    fun provideStockRepository(service: StockService): StockRepository =
        StockRepositoryImpl(service)

    @Provides
    fun provideStorageRepository(@ApplicationContext context: Context): StorageRepository =
        EncryptedFileRepository(context)

    @Provides
    @Singleton
    fun providesTokenContainer(): TokenContainer = TokenContainer()

    @Provides
    @Singleton
    fun providesGraphQLClientProvider(tokenContainer: TokenContainer, refreshHandler: TokenRefreshHandler): GraphQLClientProvider = GraphQLClientProviderImpl(
        "https://graphql-pokeapi.graphcdn.app/",
        Headers.headersOf("Content-Type", "application/json"),
        tokenContainer,
        refreshHandler
    )

    @Provides
    fun providePokemonRepository(graphQLClientProvider: GraphQLClientProvider): PokemonRepository =
        PokemonRepositoryImpl(graphQLClientProvider)


}