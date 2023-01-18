package com.dowpro.feature_sentiments

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.dowpro.library_design_system.composables.buttons.PrimaryRoundedButton
import com.dowpro.library_design_system.composables.scaffolds.MyStickyNoToolbarScaffold
import com.dowpro.library_design_system.composables.spaces.LargeSpacer
import com.dowpro.library_network.Sentiment

@Composable
fun SentimentLazyColumn(sentiments: List<Sentiment>, clickListener : (Sentiment) -> Unit) {
    // TODO: Introduce code to demonstrate knowledge of https://developer.android.com/jetpack/compose/performance/bestpractices
    MyStickyNoToolbarScaffold(content = {
        LazyColumn(modifier = Modifier.fillMaxSize()) {
            item {
                Card (modifier = Modifier.padding(8.dp)) {
                    Text(text = stringResource(R.string.sentiments_help_header), modifier = Modifier.padding(8.dp))
                }
            }
            items(sentiments) { sentiment ->
                SentimentRow(sentiment, clickListener)
            }
            item {
                LargeSpacer()
            }
        }
    }, stickyContent = {
        PrimaryRoundedButton(text = "More information") {

        }
    })


}
