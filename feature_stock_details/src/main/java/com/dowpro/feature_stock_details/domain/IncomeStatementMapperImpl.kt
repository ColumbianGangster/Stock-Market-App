package com.dowpro.feature_stock_details.domain

import kotlin.math.ln
import kotlin.math.pow

class IncomeStatementMapperImpl : IncomeStatementMapper {

    companion object {
        const val CURRENCY_SUFFIX = "kMBT"
        const val CURRENCY_STRING_FORMAT = "%.1f %c"
        const val MINUS = "-"
    }

    override fun map(incomeStatement: com.dowpro.library_network.IncomeStatement?): com.dowpro.library_network.IncomeStatement? = incomeStatement?.apply {
        annualReports?.map {
            it.formattedGrossProfit = it.grossProfit.toCompactDecimalFormat()
            it.formattedNetIncome = it.netIncome.toCompactDecimalFormat()
        }
    }

    @Deprecated(message = "Consider instead using https://developer.android.com/reference/android/icu/text/CompactDecimalFormat")
    private fun String.toCompactDecimalFormat(): String = if (startsWith(MINUS)) {
        MINUS + drop(1).toAbsCompactDecimalFormat()
    } else {
        toAbsCompactDecimalFormat()
    }

    // Credit: https://stackoverflow.com/questions/41859525/how-to-go-about-formatting-1200-to-1-2k-in-android-studio
    private fun String.toAbsCompactDecimalFormat(): String {
        if (this.toDouble() < 1000) return "" + this
        val exp = (ln(this.toDouble()) / ln(1000.0)).toInt()
        return String.format(CURRENCY_STRING_FORMAT, this.toDouble() / 1000.0.pow(exp.toDouble()), CURRENCY_SUFFIX[exp - 1])
    }
}
