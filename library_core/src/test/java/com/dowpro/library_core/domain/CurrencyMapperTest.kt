package com.dowpro.library_core.domain

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class CurrencyMapperTest {

    @ParameterizedTest
    @CsvSource(
        "0.0, GBP, GBP 00.00",
        "1.0, GBP, GBP 01.00",
        "-1.0, GBP, GBP -01.00",
        "10, GBP, GBP 10.00",
        "100, GBP, GBP 100.00",
        "1000, GBP, GBP 1000.00",
        "10000, GBP, GBP 10000.00",
        "100000, GBP, GBP 100000.00",
        "0, JPY, JPY 00",
        "1, JPY, JPY 01",
        "-1, JPY, JPY -01",
        "10, JPY, JPY 10",
        "100, JPY, JPY 100",
        "1000, JPY, JPY 1000",
        "10000, JPY, JPY 10000",
        "10, EUR, EUR 10.00",
        "100, EUR, EUR 100.00",
        "1000, EUR, EUR 1000.00",
        "10000, EUR, EUR 10000.00",
        "100000, EUR, EUR 100000.00",
        "10000, CHF, CHF 10000.00"
    )
    fun `Given 0 GBP then format correctly`(input: String, currency: String, expected: String) {
        // Given
        val SUT = CurrencyMapper()
        // When
        val actual = SUT.toISO4217TransmissionFormat(input.toBigDecimal(), currency)
        // Then
        assertEquals(expected, actual)
    }
}