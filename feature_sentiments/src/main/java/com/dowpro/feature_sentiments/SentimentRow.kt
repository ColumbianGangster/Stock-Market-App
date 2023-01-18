package com.dowpro.feature_sentiments

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*

import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.dowpro.library_design_system.composables.spaces.VerySmallSpacer
import com.dowpro.library_network.Sentiment

@Composable
fun SentimentRow(sentiment: Sentiment, clickListener: (Sentiment) -> Unit) {
    Column(modifier = Modifier.clickable {
        clickListener.invoke(sentiment)
    }) {
        Row(modifier = Modifier.padding(all = 8.dp).fillMaxWidth()) {
            val showBullish = sentiment.sentiment == stringResource(R.string.sentiment_row_bullish)
            val bullishUrl = "https://static.vecteezy.com/system/resources/thumbnails/005/425/999/small/a-silhouette-of-the-bull-with-an-increased-chart-behind-for-bullish-trend-illustration-free-vector.jpg"
            val bearishUrl = "https://st4.depositphotos.com/7801346/29995/v/450/depositphotos_299957192-stock-illustration-bear-market-bear-and-red.jpgg"

            AsyncImage(
                model = if (showBullish) bullishUrl else bearishUrl,
                contentDescription = stringResource( if (showBullish) R.string.sentiment_row_bullish else R.string.sentiment_row_bearish),
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(90.dp)
                    .align(Alignment.CenterVertically)
                    .padding(end = 8.dp)
            )

            Column (modifier = Modifier.padding(4.dp)) {
                Text(
                    text = sentiment.ticker,
                    color = MaterialTheme.colors.secondaryVariant,
                    style = MaterialTheme.typography.subtitle2,
                )

                Text(
                    text = if (sentiment.sentiment == "Bullish") "Buy" else "Sell",
                    style = MaterialTheme.typography.h5
                )

                Text(
                    text = stringResource(R.string.sentiment_row_comments, sentiment.no_of_comments),
                    modifier = Modifier.padding(top = 4.dp),
                    style = MaterialTheme.typography.body2
                )

                Text(
                    text = stringResource(R.string.sentiment_row_score, sentiment.sentiment_score),
                    modifier = Modifier.padding(top = 4.dp),
                    style = MaterialTheme.typography.body2
                )
            }
        }
        Divider(modifier = Modifier.fillMaxWidth(0.95f).align(Alignment.CenterHorizontally))
    }
}