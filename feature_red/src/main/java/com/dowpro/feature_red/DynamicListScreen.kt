package com.dowpro.feature_red

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import com.dowpro.library_design_system.composables.cards.RedContent
import com.dowpro.library_design_system.composables.cards.SimpleTextCard
import com.dowpro.library_design_system.composables.spaces.LargeSpacer

@Composable
fun RedLazyColumnScreen(modifier: Modifier = Modifier, contents: List<RedContent>) {
    LazyColumn (modifier = modifier) {
        items(contents) { content ->
            SimpleTextCard(content)
        }
        item {
            LargeSpacer()
        }
    }

}
