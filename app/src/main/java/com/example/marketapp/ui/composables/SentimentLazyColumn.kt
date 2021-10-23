package com.example.marketapp.ui.composables

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.marketapp.data.Sentiment
import androidx.compose.foundation.lazy.items

@Composable
fun SentimentLazyColumn(sentiments: List<Sentiment>, clickListener : (Sentiment) -> Unit) {
    LazyColumn(modifier = Modifier.fillMaxSize(1F)) {
        items(sentiments) { sentiment ->
            SentimentRow(sentiment, clickListener)
        }
    }
}
