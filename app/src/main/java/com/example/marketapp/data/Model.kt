package com.example.marketapp.data

data class Sentiment(
    val no_of_comments: Int,
    val sentiment: String,
    val sentiment_score: Double,
    val ticker: String
)

data class Stocks(
    val data: List<Stock>,
    val meta: Meta
)

data class Stock(
    val `52_week_high`: Double?,
    val `52_week_low`: Double?,
    val currency: String,
    val day_change: Double,
    val day_high: Double,
    val day_low: Double,
    val day_open: Double,
    val exchange_long: String,
    val exchange_short: String,
    val is_extended_hours_price: Boolean,
    val last_trade_time: String,
    val mic_code: String,
    val name: String,
    val previous_close_price: Double,
    val previous_close_price_time: String,
    val price: Double,
    val ticker: String,
    val volume: Int
)

data class Meta(
    val requested: Int,
    val returned: Int
)


data class IncomeStatement(
    val annualReports: List<AnnualReport>,
    val quarterlyReports: List<QuarterlyReport>,
    val symbol: String
)

data class AnnualReport(
    val comprehensiveIncomeNetOfTax: String,
    val costOfRevenue: String,
    val costofGoodsAndServicesSold: String,
    val depreciation: String,
    val depreciationAndAmortization: String,
    val ebit: String,
    val ebitda: String,
    val fiscalDateEnding: String,
    val grossProfit: String,
    val incomeBeforeTax: String,
    val incomeTaxExpense: String,
    val interestAndDebtExpense: String,
    val interestExpense: String,
    val interestIncome: String,
    val investmentIncomeNet: String,
    val netIncome: String,
    val netIncomeFromContinuingOperations: String,
    val netInterestIncome: String,
    val nonInterestIncome: String,
    val operatingExpenses: String,
    val operatingIncome: String,
    val otherNonOperatingIncome: String,
    val reportedCurrency: String,
    val researchAndDevelopment: String,
    val sellingGeneralAndAdministrative: String,
    val totalRevenue: String
)

data class QuarterlyReport(
    val comprehensiveIncomeNetOfTax: String,
    val costOfRevenue: String,
    val costofGoodsAndServicesSold: String,
    val depreciation: String,
    val depreciationAndAmortization: String,
    val ebit: String,
    val ebitda: String,
    val fiscalDateEnding: String,
    val grossProfit: String,
    val incomeBeforeTax: String,
    val incomeTaxExpense: String,
    val interestAndDebtExpense: String,
    val interestExpense: String,
    val interestIncome: String,
    val investmentIncomeNet: String,
    val netIncome: String,
    val netIncomeFromContinuingOperations: String,
    val netInterestIncome: String,
    val nonInterestIncome: String,
    val operatingExpenses: String,
    val operatingIncome: String,
    val otherNonOperatingIncome: String,
    val reportedCurrency: String,
    val researchAndDevelopment: String,
    val sellingGeneralAndAdministrative: String,
    val totalRevenue: String
)