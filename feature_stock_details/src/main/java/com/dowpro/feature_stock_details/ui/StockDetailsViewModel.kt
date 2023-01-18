package com.dowpro.feature_stock_details.ui

import androidx.compose.runtime.Immutable
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dowpro.feature_stock_details.domain.DomainStockDetails
import com.dowpro.feature_stock_details.domain.GetStockDetailsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
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
                _screenState.value = StockUiState(screenState = UiState.Loading)
                val result = useCase.execute(ticker)
                _screenState.value = StockUiState(screenState = UiState.Success, domainStockDetails = result)
            } catch (exception: Exception) {
                _screenState.value = StockUiState(screenState = UiState.Error, exception = exception)
            }
        }
    }
}

sealed class UiState {
    object Loading: UiState()
    object Success: UiState()
    object Error: UiState()
}

@Immutable
data class StockUiState(
    val screenState: UiState = UiState.Loading,
    val domainStockDetails: DomainStockDetails? = null,
    val exception: Throwable? = null
)