package com.dowpro.feature_sentiments

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dowpro.library_network.repos.StockRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class SentimentsViewModel @Inject constructor(private val stockRepository: StockRepository) : ViewModel() {

    val mutableLiveData = MutableLiveData<SentimentsState>()

    fun getSentiments() {
        mutableLiveData.value = SentimentsState.Loading(true)
        viewModelScope.launch {
            try {
                val sentiments = stockRepository.getSentiments()
                delay(500)
                mutableLiveData.value = SentimentsState.Success(sentiments)
            } catch (exception: Exception) {
                mutableLiveData.value = SentimentsState.Error(exception)
            }
            mutableLiveData.value = SentimentsState.Loading(false)
        }
    }
}

