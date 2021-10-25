package com.example.marketapp.ui.sentiments

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.marketapp.data.Sentiment
import com.example.marketapp.data.StockRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class MainViewModel @Inject constructor(private val stockRepository: StockRepository) : ViewModel() {

    val mutableLiveData = MutableLiveData<MainUiState>()

    fun getSentiments() {
        mutableLiveData.value = MainUiState.Loading(true)
        viewModelScope.launch {
            try {
                val sentiments = stockRepository.getSentiments()
                delay(500)
                mutableLiveData.value = MainUiState.Success(sentiments)
            } catch (exception: Exception) {
                mutableLiveData.value = MainUiState.Error(exception)
            }
            mutableLiveData.value = MainUiState.Loading(false)
        }
    }
}

sealed class MainUiState {
    data class Loading(val isLoading: Boolean): MainUiState()
    data class Success(val sentiments: List<Sentiment>): MainUiState()
    data class Error(val exception: Throwable): MainUiState()
}