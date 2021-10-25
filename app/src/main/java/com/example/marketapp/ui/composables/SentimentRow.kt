package com.example.marketapp.ui.composables

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*

import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ThumbDown
import androidx.compose.material.icons.rounded.ThumbUp
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.marketapp.R
import com.example.marketapp.data.Sentiment

@Composable
fun SentimentRow(sentiment: Sentiment, clickListener: (Sentiment) -> Unit) {
    Row(modifier = Modifier.padding(all = 8.dp)) {
        if (sentiment.sentiment == stringResource(R.string.sentiment_row_bullish)) {
            Icon(Icons.Rounded.ThumbUp, contentDescription = stringResource(R.string.sentiment_row_bullish), tint = Color.Blue)
        } else {
            Icon(Icons.Rounded.ThumbDown, contentDescription = stringResource(R.string.sentiment_row_bearish), tint = Color.Red)
        }
        Spacer(modifier = Modifier.width(8.dp))
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

            Spacer(modifier = Modifier.height(4.dp))

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