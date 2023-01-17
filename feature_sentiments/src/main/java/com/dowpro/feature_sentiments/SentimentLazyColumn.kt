package com.dowpro.feature_sentiments

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.dowpro.library_network.Sentiment

@Composable
fun SentimentLazyColumn(sentiments: List<Sentiment>, clickListener : (Sentiment) -> Unit) {
    LazyColumn(modifier = Modifier.fillMaxSize()) {
        items(sentiments) { sentiment ->
            SentimentRow(sentiment, clickListener)
        }
    }
}
