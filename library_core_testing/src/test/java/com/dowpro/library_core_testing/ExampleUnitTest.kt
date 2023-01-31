package com.dowpro.library_core_testing


import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    @ParameterizedTest
    @CsvSource(
        "-1, -1, -2",
        "0, 0, 0",
        "1, 1, 2"
    )
    fun `addition is correct parameterised test`(first: Int, second: Int, expected: Int) {
        assertEquals(expected, first + second)
    }
}