package com.dowpro.feature_stock_details.ui

import androidx.compose.runtime.Immutable
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dowpro.feature_stock_details.domain.DomainStockDetails
import com.dowpro.feature_stock_details.domain.GetStockDetailsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class StockDetailsViewModel @Inject constructor(private val useCase: GetStockDetailsUseCase) : ViewModel() {

    private val _screenState = MutableLiveData(StockUiState())
    val screenState: LiveData<StockUiState>
        get() = _screenState

    fun getStock(ticker: String) {
        viewModelScope.launch {
            try {
                _screenState.value = StockUiState(screenState = UiState.LOADING)
                val result = useCase.execute(ticker)
                _screenState.value = StockUiState(screenState = UiState.SUCCESS, domainStockDetails = result)
                delay(500) // is this needed?
            } catch (exception: Exception) {
                _screenState.value = StockUiState(screenState = UiState.ERROR, exception = exception)
            }
        }
    }
}

sealed class UiState {
    object LOADING: UiState()
    object SUCCESS: UiState()
    object ERROR: UiState()
}

@Immutable
data class StockUiState(
    val screenState: UiState = UiState.LOADING,
    val domainStockDetails: DomainStockDetails? = null,
    val exception: Throwable? = null
)