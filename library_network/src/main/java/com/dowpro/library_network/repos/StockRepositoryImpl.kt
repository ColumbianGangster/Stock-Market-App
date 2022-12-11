package com.dowpro.library_network.repos

import com.dowpro.library_network.*
import com.dowpro.library_network.services.StockService

class StockRepositoryImpl(private val apiService: StockService) :
    StockRepository {

    companion object {
        const val INCOME_STATEMENT = "INCOME_STATEMENT"
        const val OVERVIEW = "OVERVIEW"
    }

    override suspend fun getSentiments(): List<Sentiment> = apiService.getSentiments()

    override suspend fun getStock(ticker: String) =
        apiService.getStocks(ticker, "").data.firstOrNull()

    override suspend fun getStocks(tickers: List<String>) =
        apiService.getStocks(tickers.joinToString(separator = "%"), BuildConfig.STOCK_DATA_API_KEY)

    override suspend fun getIncomeStatement(ticker: String): IncomeStatement =
        apiService.getIncomeStatement(INCOME_STATEMENT, ticker, BuildConfig.ALPHAVANTAGE_API_KEY)

    override suspend fun getCompanyOverview(ticker: String): CompanyOverview =
        apiService.getCompanyOverview(OVERVIEW, ticker, BuildConfig.ALPHAVANTAGE_API_KEY)
}
