package com.example.marketapp.domain

import com.example.marketapp.data.IncomeStatement
import kotlin.math.ln
import kotlin.math.pow

class IncomeStatementMapperImpl : IncomeStatementMapper {

    companion object {
        const val CURRENCY_SUFFIX = "kMBT"
        const val CURRENCY_STRING_FORMAT = "%.1f %c"
        const val MINUS = "-"
    }
    override fun map(incomeStatement: IncomeStatement?): IncomeStatement? = incomeStatement?.apply {
        annualReports?.map {
            it.formattedGrossProfit = it.grossProfit.getFormatedNumber()
            it.formattedNetIncome = it.netIncome.getFormatedNumber()
        }
    }

    private fun String.getFormatedNumber(): String = if (startsWith(MINUS)) {
        MINUS + drop(1).getFormattedInner()
    } else {
        getFormattedInner()
    }

    // Credit: https://stackoverflow.com/questions/41859525/how-to-go-about-formatting-1200-to-1-2k-in-android-studio
    private fun String.getFormattedInner(): String {
        if (this.toDouble() < 1000) return "" + this
        val exp = (ln(this.toDouble()) / ln(1000.0)).toInt()
        return String.format(CURRENCY_STRING_FORMAT, this.toDouble() / 1000.0.pow(exp.toDouble()), CURRENCY_SUFFIX[exp - 1])
    }
}
