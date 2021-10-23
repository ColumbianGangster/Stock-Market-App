package com.example.marketapp.data

interface StockRepository {

    suspend fun getSentiments(): List<Sentiment>
}