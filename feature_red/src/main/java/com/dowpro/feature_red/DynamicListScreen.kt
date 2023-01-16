package com.dowpro.feature_red

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.dowpro.library_design_system.theme.Typography

data class RedContent(val title: String, val body: String)

@Composable
fun RedLazyColumnScreen(contents: List<RedContent>) {
    LazyColumn {
        items(contents) { content ->
            MyCard(content)
        }
    }
    Spacer(Modifier.size(90.dp))
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyCard(content: RedContent) {
    var selected: Boolean by remember { mutableStateOf(false) }
    // GM2: Shadows applied at all levels.
    // GM3: Using color instead of shadows to communicate elevation.
    // Source: https://m3.material.io/styles/elevation/overview
    Card(
        onClick = { selected = !selected },
        modifier = Modifier.padding(4.dp).fillMaxWidth().clickable {  },
    ) {
//        Box(Modifier.fillMaxSize()) {
//            Row(
//                verticalAlignment = Alignment.CenterVertically,
//                modifier = Modifier.fillMaxWidth()) {
//                Column(modifier = Modifier.padding(8.dp)) {
//                    Text(content.title, style = Typography.h5)
//                    Text(content.body, modifier = Modifier.fillMaxWidth(0.9F))
//                }
//            }
//        }
        Column(modifier = Modifier.padding(8.dp)) {
                    Text(content.title, style = Typography.h5)
                    Text(content.body, modifier = Modifier.fillMaxWidth(0.9F))
        }
    }
}