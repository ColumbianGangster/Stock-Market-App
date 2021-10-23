package com.example.marketapp.data

import javax.inject.Inject

class StockRepositoryImpl @Inject constructor(private val apiService: StockService) : StockRepository {

    override suspend fun getSentiments(): List<Sentiment> = apiService.getSentiments()
    override suspend fun getStock(ticker: String) = apiService.getStocks(ticker, "PW7bsJU6JCIvlqFstqnI1tGOgUIgf7FeaUQbCeqp").data.firstOrNull()
    override suspend fun getStocks(tickers: List<String>) = apiService.getStocks(tickers.joinToString(separator = "%"), "PW7bsJU6JCIvlqFstqnI1tGOgUIgf7FeaUQbCeqp")
    override suspend fun getIncomeStatement(ticker: String): IncomeStatement = apiService.getIncomeStatement("INCOME_STATEMENT", ticker, "O19XN9FFTR09SV72")


}
