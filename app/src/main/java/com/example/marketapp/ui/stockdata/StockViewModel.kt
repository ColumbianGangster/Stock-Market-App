package com.example.marketapp.ui.stockdata

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.marketapp.data.*
import com.example.marketapp.ui.sentiments.MainUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.lang.IllegalStateException
import javax.inject.Inject

@HiltViewModel
class StockViewModel @Inject constructor(private val stockRepository: StockRepository) : ViewModel() {

    val mutableLiveData = MutableLiveData<StockUiState>()

    fun getStock(ticker: String) {
        mutableLiveData.value = StockUiState.Loading(true)
        viewModelScope.launch {
            try {
                stockRepository.getStock(ticker)?.let { stock ->
                    stockRepository.getIncomeStatement(ticker).let { incomeStatement ->
                        stockRepository.getCompanyOverview(ticker).let { companyOverview ->
                            mutableLiveData.value = StockUiState.Success(Model(stock, incomeStatement, companyOverview))
                        }
                    }
                }?: run {
                    mutableLiveData.value = StockUiState.Error(IllegalStateException("No such ticker"))
                }
                delay(500)
            } catch (exception: Exception) {
                mutableLiveData.value = StockUiState.Error(exception)
            }
            mutableLiveData.value = StockUiState.Loading(false)
        }
    }
}

data class Model(val stock: Stock, val incomeStatement: IncomeStatement, val companyOverview: CompanyOverview)

sealed class StockUiState {
    data class Loading(val isLoading: Boolean): StockUiState()
    data class Success(val model: Model): StockUiState()
    data class Error(val exception: Throwable): StockUiState()
}