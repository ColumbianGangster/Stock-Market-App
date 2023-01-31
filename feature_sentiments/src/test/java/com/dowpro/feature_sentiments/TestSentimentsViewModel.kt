package com.dowpro.feature_sentiments


import androidx.lifecycle.Observer
import com.dowpro.library_core_testing.junit5.CoroutinesTestExtension
import com.dowpro.library_core_testing.junit5.InstantExecutorExtension
import com.dowpro.library_network.Sentiment
import com.dowpro.library_network.repos.StockRepository
import org.junit.jupiter.api.Test
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import io.mockk.verify
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.jupiter.api.extension.ExtendWith
import org.junit.jupiter.api.extension.Extensions


@OptIn(ExperimentalCoroutinesApi::class)
@Extensions(ExtendWith(InstantExecutorExtension::class), ExtendWith(CoroutinesTestExtension::class))
class TestSentimentsViewModel {

    @Test
    fun `given the screen gets sentiments with success then show the success state`() {
        // Given
        val response = mockk<List<Sentiment>>()
        val stockRepository = mockk<StockRepository> {
            coEvery { getSentiments() } returns response
        }
        val observer = mockk<Observer<SentimentsState>>(relaxed = true)
        val SUT = SentimentsViewModel(stockRepository)
        SUT.sentiments.observeForever(observer)
        // When
        SUT.getSentiments()

        // Then
        coVerify (exactly = 1) { stockRepository.getSentiments() }
        verify (exactly = 1) { observer.onChanged(SentimentsState.Loading(true)) }
        verify (exactly = 1) { observer.onChanged(SentimentsState.Loading(false)) }
        verify (exactly = 1) { observer.onChanged(SentimentsState.Success(response)) }
    }

    @Test
    fun `given the screen gets sentiments with error then show the error state`() {
        // Given
        val exception = mockk<Exception>()
        val stockRepository = mockk<StockRepository> {
            coEvery { getSentiments() } throws exception
        }
        val observer = mockk<Observer<SentimentsState>>(relaxed = true)
        val SUT = SentimentsViewModel(stockRepository)
        SUT.sentiments.observeForever(observer)
        // When
        SUT.getSentiments()

        // Then
        coVerify (exactly = 1) { stockRepository.getSentiments() }
        verify (exactly = 1) { observer.onChanged(SentimentsState.Loading(true)) }
        verify (exactly = 1) { observer.onChanged(SentimentsState.Loading(false)) }
        verify (exactly = 1) { observer.onChanged(SentimentsState.Error(exception)) }
    }
}
