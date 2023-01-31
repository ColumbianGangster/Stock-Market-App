package com.dowpro.library_network.repos

import com.dowpro.library_core_testing.junit5.CoroutinesTestExtension
import com.dowpro.library_core_testing.junit5.InstantExecutorExtension
import com.dowpro.library_network.IncomeStatement
import com.dowpro.library_network.Meta
import com.dowpro.library_network.Stocks
import com.dowpro.library_network.services.StockService

import org.junit.jupiter.api.Test
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.extension.ExtendWith
import org.junit.jupiter.api.extension.Extensions

@OptIn(ExperimentalCoroutinesApi::class)
@Extensions(ExtendWith(InstantExecutorExtension::class), ExtendWith(CoroutinesTestExtension::class))
class TestStockRepositoryImpl {

    @Nested
    inner class GetSentiments {
        @Test
        fun `Given sentiments is called successfully, Then pass through`() = runTest {
            // Given
            val stockService = mockk<StockService> {
                coEvery { getSentiments() } returns emptyList()
            }

            val SUT = StockRepositoryImpl(stockService)

            // When
            SUT.getSentiments()

            // Then
            coVerify (exactly = 1) { stockService.getSentiments() }
        }

        @Test
        fun `Given sentiments returns with error, then pass error`() {
            // Given
            val stockService = mockk<StockService> {
                coEvery { getSentiments() } throws Exception()
            }
            val SUT = StockRepositoryImpl(stockService)

            // When
            Assertions.assertThrows(Exception::class.java) {
                runTest {
                    SUT.getSentiments()
                }
            }

            // Then
            coVerify (exactly = 1) { stockService.getSentiments() }
        }
    }

    @Nested
    inner class GetStockDetails {
        @Test
        fun `Given stock details is called successfully, Then pass through`() = runTest {
            // Given
            val stockService = mockk<StockService> {
                coEvery { getStocks(any(), any()) } returns Stocks(emptyList(), Meta(0, 0))
            }

            val SUT = StockRepositoryImpl(stockService)

            // When
            SUT.getStocks(emptyList())

            // Then
            coVerify (exactly = 1) { stockService.getStocks(any(), any()) }
        }

        @Test
        fun `Given stock details returns with error, then pass error`() {
            // Given
            val stockService = mockk<StockService> {
                coEvery { getStocks(any(), any()) } throws Exception()
            }

            val SUT = StockRepositoryImpl(stockService)

            // When
            Assertions.assertThrows(Exception::class.java) {
                runTest {
                    SUT.getStock("")
                }
            }

            // Then
            coVerify (exactly = 1) { stockService.getStocks(any(), any()) }
        }
    }

    @Nested
    inner class GetIncomeStatement {
        @Test
        fun `Given income statement is called successfully, Then pass through`() = runTest {
            // Given
            val stockService = mockk<StockService> {
                coEvery { getIncomeStatement(any(), any(), any()) } returns IncomeStatement(
                    emptyList(), emptyList(), ""
                )
            }

            val SUT = StockRepositoryImpl(stockService)

            // When
            SUT.getIncomeStatement("")

            // Then
            coVerify (exactly = 1) { stockService.getIncomeStatement(any(), any(), any()) }
        }

        @Test
        fun `Given income statement returns with error, then pass error`() {
            // Given
            val stockService = mockk<StockService> {
                coEvery { getIncomeStatement(any(), any(), any()) } throws Exception()
            }

            val SUT = StockRepositoryImpl(stockService)

            // When
            Assertions.assertThrows(Exception::class.java) {
                runTest {
                    SUT.getIncomeStatement("")
                }
            }

            // Then
            coVerify (exactly = 1) { stockService.getIncomeStatement(any(), any(), any()) }
        }
    }
}