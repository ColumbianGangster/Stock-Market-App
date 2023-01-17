package com.dowpro.feature_sentiments

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*

import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.dowpro.library_design_system.composables.spaces.SmallSpacer
import com.dowpro.library_design_system.composables.spaces.VerySmallSpacer

@Composable
fun SentimentRow(sentiment: com.dowpro.library_network.Sentiment, clickListener: (com.dowpro.library_network.Sentiment) -> Unit) {
    Row(modifier = Modifier.padding(all = 8.dp)) {
        if (sentiment.sentiment == stringResource(R.string.sentiment_row_bullish)) {
            AsyncImage(
                model = "https://static.vecteezy.com/system/resources/thumbnails/005/425/999/small/a-silhouette-of-the-bull-with-an-increased-chart-behind-for-bullish-trend-illustration-free-vector.jpg",
                contentDescription = stringResource(R.string.sentiment_row_bullish),
                modifier = Modifier.height(48.dp)
            )
        } else {
            AsyncImage(
                model = "https://st4.depositphotos.com/7801346/29995/v/450/depositphotos_299957192-stock-illustration-bear-market-bear-and-red.jpgg",
                contentDescription = stringResource(R.string.sentiment_row_bearish),
                modifier = Modifier.height(48.dp)
            )
        }
        SmallSpacer()
        Column(modifier = Modifier
            .clickable {
                clickListener.invoke(sentiment)
            }
            .fillMaxWidth()) {
            Text(
                text = sentiment.ticker,
                color = MaterialTheme.colors.secondaryVariant,
                style = MaterialTheme.typography.subtitle2
            )

            VerySmallSpacer()

            Surface(
                shape = MaterialTheme.shapes.medium,
                elevation = 1.dp,
                modifier = Modifier
                    .animateContentSize()
                    .padding(1.dp)
                    .fillMaxWidth()
            ) {
                Column {
                    Text(
                        text = stringResource(R.string.sentiment_row_sentiment, sentiment.sentiment),
                        modifier = Modifier.padding(all = 4.dp),
                        style = MaterialTheme.typography.body2
                    )

                    Text(
                        text = stringResource(R.string.sentiment_row_comments, sentiment.no_of_comments),
                        modifier = Modifier.padding(all = 4.dp),
                        style = MaterialTheme.typography.body2
                    )

                    Text(
                        text = stringResource(R.string.sentiment_row_score, sentiment.sentiment_score),
                        modifier = Modifier.padding(all = 4.dp),
                        style = MaterialTheme.typography.body2
                    )
                }
            }
        }
    }
}