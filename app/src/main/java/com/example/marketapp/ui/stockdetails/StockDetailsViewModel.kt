package com.example.marketapp.ui.stockdetails

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.marketapp.domain.GetStockDetailsUseCase
import com.example.marketapp.domain.DomainStockDetails
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class StockViewModel @Inject constructor(private val useCase: GetStockDetailsUseCase) : ViewModel() {

    val mutableLiveData = MutableLiveData<StockUiState>()

    fun getStock(ticker: String) {
        mutableLiveData.value = StockUiState.Loading(true)
        viewModelScope.launch {
            try {
                mutableLiveData.value = StockUiState.Success(useCase.execute(ticker))
                delay(500)
            } catch (exception: Exception) {
                mutableLiveData.value = StockUiState.Error(exception)
            }
            mutableLiveData.value = StockUiState.Loading(false)
        }
    }
}

sealed class StockUiState {
    data class Loading(val isLoading: Boolean): StockUiState()
    data class Success(val domainStockDetails: DomainStockDetails): StockUiState()
    data class Error(val exception: Throwable): StockUiState()
}