package com.example.marketapp.data

import retrofit2.http.GET

interface StockService {
    @GET("api/v1/apps/reddit")
    suspend fun getSentiments(): List<Sentiment>
}