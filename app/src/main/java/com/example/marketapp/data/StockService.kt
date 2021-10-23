package com.example.marketapp.data

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
}