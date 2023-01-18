package com.dowpro.marketapp.domain

import com.dowpro.feature_stock_details.domain.IncomeStatementMapperImpl
import com.dowpro.library_network.AnnualReport
import com.dowpro.library_network.IncomeStatement
import org.junit.Assert.assertEquals
import org.junit.Test

class IncomeStatementMapperTest {

    @Test
    fun `Given the gross profit of an annual report is 1000, when we the user sees the gross profit, then the user sees 1 k`() {
        val input = IncomeStatement(
            annualReports = mutableListOf<AnnualReport>().apply {
                add(generateAnnualReport("1000", "1000"))
            },
            quarterlyReports = emptyList(),
            symbol = "",
        )
        val SUT = IncomeStatementMapperImpl()
        val output = SUT.map(input)
        assertEquals("1.0 k", output?.annualReports?.firstOrNull()?.formattedNetIncome)
    }

    @Test
    fun `Given the gross profit of an annual report is 1100, when we the user sees the gross profit, then the user sees 1 pt 1 k`() {
        val input = IncomeStatement(
            annualReports = mutableListOf<AnnualReport>().apply {
                add(generateAnnualReport("1100", "1100"))
            },
            quarterlyReports = emptyList(),
            symbol = "",
        )
        val SUT = IncomeStatementMapperImpl()
        val output = SUT.map(input)
        assertEquals("1.1 k", output?.annualReports?.firstOrNull()?.formattedNetIncome)
    }

    @Test
    fun `Given the gross profit of an annual report is 900, when we the user sees the gross profit, then the user sees 900`() {
        val input = IncomeStatement(
            annualReports = mutableListOf<AnnualReport>().apply {
                add(generateAnnualReport("900", "900"))
            },
            quarterlyReports = emptyList(),
            symbol = "",
        )
        val SUT = IncomeStatementMapperImpl()
        val output = SUT.map(input)
        assertEquals("900", output?.annualReports?.firstOrNull()?.formattedNetIncome)
    }

    @Test
    fun `Given the gross profit of an annual report is 10000, when we the user sees the gross profit, then the user sees 10 k`() {
        val input = IncomeStatement(
            annualReports = mutableListOf<AnnualReport>().apply {
                add(generateAnnualReport("10000", "10000"))
            },
            quarterlyReports = emptyList(),
            symbol = "",
        )
        val SUT = IncomeStatementMapperImpl()
        val output = SUT.map(input)
        assertEquals("10.0 k", output?.annualReports?.firstOrNull()?.formattedNetIncome)
    }

    @Test
    fun `Given the gross profit of an annual report is 1 million, when we the user sees the gross profit, then the user sees 1 M`() {
        val input = IncomeStatement(
            annualReports = mutableListOf<AnnualReport>().apply {
                add(generateAnnualReport("1000000", "1000000"))
            },
            quarterlyReports = emptyList(),
            symbol = "",
        )
        val SUT = IncomeStatementMapperImpl()
        val output = SUT.map(input)
        assertEquals("1.0 M", output?.annualReports?.firstOrNull()?.formattedNetIncome)
    }

    @Test
    fun `Given the gross profit of an annual report is 1 billion, when we the user sees the gross profit, then the user sees 1 B`() {
        val input = IncomeStatement(
            annualReports = mutableListOf<AnnualReport>().apply {
                add(generateAnnualReport("1000000000", "1000000000"))
            },
            quarterlyReports = emptyList(),
            symbol = "",
        )
        val SUT = IncomeStatementMapperImpl()
        val output = SUT.map(input)
        assertEquals("1.0 B", output?.annualReports?.firstOrNull()?.formattedNetIncome)
    }

    @Test
    fun `Given the gross profit of an annual report is 1 trillion, when we the user sees the gross profit, then the user sees 1 T`() {
        val input = IncomeStatement(
            annualReports = mutableListOf<AnnualReport>().apply {
                add(generateAnnualReport("1000000000000", "1000000000000"))
            },
            quarterlyReports = emptyList(),
            symbol = "",
        )
        val SUT = IncomeStatementMapperImpl()
        val output = SUT.map(input)
        assertEquals("1.0 T", output?.annualReports?.firstOrNull()?.formattedNetIncome)
    }

    @Test
    fun `Given the gross profit of an annual report is -1000, when we the user sees the gross profit, then the user sees -1 k`() {
        val input = IncomeStatement(
            annualReports = mutableListOf<AnnualReport>().apply {
                add(generateAnnualReport("-1000", "-1000"))
            },
            quarterlyReports = emptyList(),
            symbol = "",
        )
        val SUT = IncomeStatementMapperImpl()
        val output = SUT.map(input)
        assertEquals("-1.0 k", output?.annualReports?.firstOrNull()?.formattedNetIncome)
    }

    @Test
    fun `Given the gross profit of an annual report is -1100, when we the user sees the gross profit, then the user sees -1 pt 1 k`() {
        val input = IncomeStatement(
            annualReports = mutableListOf<AnnualReport>().apply {
                add(generateAnnualReport("-1100", "-1100"))
            },
            quarterlyReports = emptyList(),
            symbol = "",
        )
        val SUT = IncomeStatementMapperImpl()
        val output = SUT.map(input)
        assertEquals("-1.1 k", output?.annualReports?.firstOrNull()?.formattedNetIncome)
    }

    @Test
    fun `Given the gross profit of an annual report is -900, when we the user sees the gross profit, then the user sees -900`() {
        val input = IncomeStatement(
            annualReports = mutableListOf<AnnualReport>().apply {
                add(generateAnnualReport("-900", "-900"))
            },
            quarterlyReports = emptyList(),
            symbol = "",
        )
        val SUT = IncomeStatementMapperImpl()
        val output = SUT.map(input)
        assertEquals("-900", output?.annualReports?.firstOrNull()?.formattedNetIncome)
    }

    @Test
    fun `Given the gross profit of an annual report is -10000, when we the user sees the gross profit, then the user sees -10 k`() {
        val input = IncomeStatement(
            annualReports = mutableListOf<AnnualReport>().apply {
                add(generateAnnualReport("-10000", "-10000"))
            },
            quarterlyReports = emptyList(),
            symbol = "",
        )
        val SUT = IncomeStatementMapperImpl()
        val output = SUT.map(input)
        assertEquals("-10.0 k", output?.annualReports?.firstOrNull()?.formattedNetIncome)
    }

    @Test
    fun `Given the gross profit of an annual report is -1 million, when we the user sees the gross profit, then the user sees -1 M`() {
        val input = IncomeStatement(
            annualReports = mutableListOf<AnnualReport>().apply {
                add(generateAnnualReport("-1000000", "-1000000"))
            },
            quarterlyReports = emptyList(),
            symbol = "",
        )
        val SUT = IncomeStatementMapperImpl()
        val output = SUT.map(input)
        assertEquals("-1.0 M", output?.annualReports?.firstOrNull()?.formattedNetIncome)
    }

    @Test
    fun `Given the gross profit of an annual report is -1 billion, when we the user sees the gross profit, then the user sees -1 B`() {
        val input = IncomeStatement(
            annualReports = mutableListOf<AnnualReport>().apply {
                add(generateAnnualReport("-1000000000", "-1000000000"))
            },
            quarterlyReports = emptyList(),
            symbol = "",
        )
        val SUT = IncomeStatementMapperImpl()
        val output = SUT.map(input)
        assertEquals("-1.0 B", output?.annualReports?.firstOrNull()?.formattedNetIncome)
    }

    @Test
    fun `Given the gross profit of an annual report is -1 trillion, when we the user sees the gross profit, then the user sees -1 T`() {
        val input = IncomeStatement(
            annualReports = mutableListOf<AnnualReport>().apply {
                add(generateAnnualReport("-1000000000000", "-1000000000000"))
            },
            quarterlyReports = emptyList(),
            symbol = "",
        )
        val SUT = IncomeStatementMapperImpl()
        val output = SUT.map(input)
        assertEquals("-1.0 T", output?.annualReports?.firstOrNull()?.formattedNetIncome)
    }

    private fun generateAnnualReport(grossProfit: String, netIncome: String) =
        AnnualReport(
            comprehensiveIncomeNetOfTax = "",
            costOfRevenue = "",
            costofGoodsAndServicesSold = "",
            depreciation = "",
            depreciationAndAmortization = "",
            ebit = "",
            ebitda = "",
            fiscalDateEnding = "",
            grossProfit = grossProfit,
            formattedGrossProfit = "",
            incomeBeforeTax = "",
            incomeTaxExpense = "",
            interestAndDebtExpense = "",
            interestExpense = "",
            interestIncome = "",
            investmentIncomeNet = "",
            netIncome = netIncome,
            formattedNetIncome = "",
            netIncomeFromContinuingOperations = "",
            netInterestIncome = "",
            nonInterestIncome = "",
            operatingExpenses = "",
            operatingIncome = "",
            otherNonOperatingIncome = "",
            reportedCurrency = "",
            researchAndDevelopment = "",
            sellingGeneralAndAdministrative = "",
            totalRevenue = ""
        )
}