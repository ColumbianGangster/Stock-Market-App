package com.example.marketapp.data


import javax.inject.Inject

class StockRepositoryImpl @Inject constructor(private val apiService: StockService) : StockRepository {
    override suspend fun getSentiments(): List<Sentiment> = apiService.getSentiments()
}