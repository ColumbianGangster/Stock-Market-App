package com.example.marketapp.ui.composables

import androidx.compose.animation.animateColorAsState
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
import androidx.compose.ui.unit.dp
import com.example.marketapp.data.Sentiment

@Composable
fun SentimentRow(sentiment: Sentiment, clickListener: (Sentiment) -> Unit) {
    // https://developer.android.com/reference/kotlin/androidx/compose/material/icons/Icons
    Row(modifier = Modifier.padding(all = 8.dp)) {
        if (sentiment.sentiment == "Bullish") {
            Icon(Icons.Rounded.ThumbUp, contentDescription = "Bullish", tint = Color.Blue)
        } else {
            Icon(Icons.Rounded.ThumbDown, contentDescription = "Bearish", tint = Color.Red)
        }

        Spacer(modifier = Modifier.width(8.dp))

        // We keep track if the message is expanded or not in this
        // variable
        var isExpanded by remember { mutableStateOf(false) }
        // surfaceColor will be updated gradually from one color to the other
        val surfaceColor: Color by animateColorAsState(
            if (isExpanded) MaterialTheme.colors.primary else MaterialTheme.colors.surface,
        )

        // We toggle the isExpanded variable when we click on this Column
        Column(modifier = Modifier
            .clickable {
                isExpanded = !isExpanded
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
                // surfaceColor color will be changing gradually from primary to surface
                color = surfaceColor,
                // animateContentSize will change the Surface size gradually
                modifier = Modifier
                    .animateContentSize()
                    .padding(1.dp)
                    .fillMaxWidth()
            ) {
                Column {
                    Text(
                        text = "Sentiment: ${sentiment.sentiment}",
                        modifier = Modifier.padding(all = 4.dp),
                        // If the message is expanded, we display all its content
                        // otherwise we only display the first line
                        maxLines = if (isExpanded) Int.MAX_VALUE else 1,
                        style = MaterialTheme.typography.body2
                    )

                    Text(
                        text = "Number of Comments: ${sentiment.no_of_comments}",
                        modifier = Modifier.padding(all = 4.dp),
                        // If the message is expanded, we display all its content
                        // otherwise we only display the first line
                        maxLines = if (isExpanded) Int.MAX_VALUE else 1,
                        style = MaterialTheme.typography.body2
                    )

                    Text(
                        text = "Sentiment Score: ${sentiment.sentiment_score}",
                        modifier = Modifier.padding(all = 4.dp),
                        // If the message is expanded, we display all its content
                        // otherwise we only display the first line
                        maxLines = if (isExpanded) Int.MAX_VALUE else 1,
                        style = MaterialTheme.typography.body2
                    )
                }
            }
        }
    }
}