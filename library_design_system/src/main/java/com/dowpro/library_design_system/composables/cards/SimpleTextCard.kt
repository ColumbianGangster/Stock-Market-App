package com.dowpro.library_design_system.composables.cards

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.dowpro.library_design_system.theme.Typography

data class RedContent(val title: String, val body: String)

@Composable
fun SimpleTextCard(content: RedContent, modifier: Modifier = Modifier) {
    // GM2: Shadows applied at all levels.
    // GM3: Using color instead of shadows to communicate elevation.
    // Source: https://m3.material.io/styles/elevation/overview
    Card(
        modifier = modifier.padding(4.dp).fillMaxWidth().clickable {  },
    ) {
        Column(modifier = Modifier.padding(8.dp)) {
                    Text(content.title, style = Typography.h5)
                    Text(content.body, modifier = Modifier.fillMaxWidth(0.9F).padding(top = 8.dp))
        }
    }
}