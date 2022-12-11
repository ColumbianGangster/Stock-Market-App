package com.dowpro.feature_sentiments

import com.dowpro.library_network.Sentiment

sealed class SentimentsState {
    data class Loading(val isLoading: Boolean): SentimentsState()
    data class Success(val sentiments: List<Sentiment>): SentimentsState()
    data class Error(val exception: Throwable): SentimentsState()
}