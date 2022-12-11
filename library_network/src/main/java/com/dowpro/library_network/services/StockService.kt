package com.dowpro.library_network.services

import com.dowpro.library_network.CompanyOverview
import com.dowpro.library_network.IncomeStatement
import com.dowpro.library_network.Sentiment
import com.dowpro.library_network.Stocks
import retrofit2.http.GET
import retrofit2.http.Query

interface StockService {
    @GET("api/v1/apps/reddit")
    suspend fun getSentiments(): List<Sentiment>

    @GET("https://api.stockdata.org/v1/data/quote")
    suspend fun getStocks(
        @Query("symbols") symbols: String,
        @Query("api_token") api_token: String
    ): Stocks

    @GET("https://www.alphavantage.co/query")
    suspend fun getIncomeStatement(
        @Query("function") function: String,
        @Query("symbol") symbol: String,
        @Query("apikey") apikey: String
    ): IncomeStatement

    @GET("https://www.alphavantage.co/query")
    suspend fun getCompanyOverview(
        @Query("function") function: String,
        @Query("symbol") symbol: String,
        @Query("apikey") apikey: String
    ): CompanyOverview
}