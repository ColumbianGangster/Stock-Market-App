package com.dowpro.library_core.domain

import java.math.BigDecimal
import java.text.DecimalFormat
import java.util.*

class CurrencyMapper {

    /*
    Formats the given amount according to the specified currency code.
    Strips out invalid fractional digits based on the ISO 4217 currency code,
    therefore this shgould be checked at validation. Currency.getInstance(locale)
    is not used because that only supports ISO 3166 countries.

    Usage example:
        Code , Amount      , Output
        JPY  , 1000        , JPY 1000
        UK   , 1000.0      , GBP 1000.00
        UK   , -1000.0     , GBP -1000.00
        UK   , 1000.1      , GBP 1000.10
        JOD  , 1000.101    , JOD 1000.101

        UYW is not supported, throwing  IllegalArgumentException, which has 4 fractional digits.
     */
    fun toISO4217TransmissionFormat(amount: BigDecimal, iso4217Code: String = "GBP") = Currency.getInstance(iso4217Code).let {
        "${it.currencyCode} ${ it.internationalFormatter().format(amount)}"
    }

    private fun Currency.internationalFormatter() = DecimalFormat().
            apply {
                isDecimalSeparatorAlwaysShown = false
                applyPattern(defaultFractionDigits
                    .takeIf { it > 0 }
                    ?.let {
                        "00.${"0".repeat(defaultFractionDigits)}"
                    }
                    ?: "00")
            }
}