package com.dowpro.library_network.repos

import com.dowpro.library_network.*

interface StockRepository {
    suspend fun getSentiments(): List<Sentiment>
    suspend fun getStock(ticker: String): Stock?
    suspend fun getStocks(tickers: List<String>): Stocks
    suspend fun getIncomeStatement(ticker: String): IncomeStatement
    suspend fun getCompanyOverview(ticker: String): CompanyOverview
}