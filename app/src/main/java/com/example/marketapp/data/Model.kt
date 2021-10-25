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
    val annualReports: List<AnnualReport>?,
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
    var formattedGrossProfit: String?,
    val incomeBeforeTax: String,
    val incomeTaxExpense: String,
    val interestAndDebtExpense: String,
    val interestExpense: String,
    val interestIncome: String,
    val investmentIncomeNet: String,
    val netIncome: String,
    var formattedNetIncome: String,
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


data class CompanyOverview(
    val `200DayMovingAverage`: String,
    val `50DayMovingAverage`: String,
    val `52WeekHigh`: String,
    val `52WeekLow`: String,
    val Address: String,
    val AnalystTargetPrice: String,
    val AssetType: String,
    val Beta: String,
    val BookValue: String,
    val CIK: String,
    val Country: String?,
    val Currency: String,
    val Description: String?,
    val DilutedEPSTTM: String,
    val DividendDate: String,
    val DividendPerShare: String,
    val DividendYield: String,
    val EBITDA: String,
    val EPS: String,
    val EVToEBITDA: String,
    val EVToRevenue: String,
    val ExDividendDate: String,
    val Exchange: String,
    val FiscalYearEnd: String,
    val ForwardAnnualDividendRate: String,
    val ForwardAnnualDividendYield: String,
    val ForwardPE: String,
    val GrossProfitTTM: String,
    val Industry: String?,
    val LastSplitDate: String,
    val LastSplitFactor: String,
    val LatestQuarter: String,
    val MarketCapitalization: String,
    val Name: String,
    val OperatingMarginTTM: String,
    val PEGRatio: String,
    val PERatio: String,
    val PayoutRatio: String,
    val PercentInsiders: String,
    val PercentInstitutions: String,
    val PriceToBookRatio: String,
    val PriceToSalesRatioTTM: String,
    val ProfitMargin: String,
    val QuarterlyEarningsGrowthYOY: String,
    val QuarterlyRevenueGrowthYOY: String,
    val ReturnOnAssetsTTM: String,
    val ReturnOnEquityTTM: String,
    val RevenuePerShareTTM: String,
    val RevenueTTM: String,
    val Sector: String?,
    val SharesFloat: String,
    val SharesOutstanding: String,
    val SharesShort: String,
    val SharesShortPriorMonth: String,
    val ShortPercentFloat: String,
    val ShortPercentOutstanding: String,
    val ShortRatio: String,
    val Symbol: String,
    val TrailingPE: String
)