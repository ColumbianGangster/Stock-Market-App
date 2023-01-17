package com.dowpro.library_design_system.composables.cards

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.dowpro.library_design_system.theme.Typography

data class RowContent(val title: String, val icon: ImageVector, val contentDescription: Int)

@Composable
fun IconCardLazyRow(contents: List<RowContent>) {
    LazyRow {
        items(contents) { content ->
            IconCardRow(content)
        }
    }
    Spacer(Modifier.size(90.dp))
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun IconCardRow(content: RowContent) {
    Card(
        onClick = {  },
        modifier = Modifier.padding(4.dp).fillMaxWidth().clickable {  },
    ) {
        Box(Modifier.width(120.dp)) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()) {
                Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.padding(8.dp).fillMaxWidth()) {
                    // I didn't use an ImageButton, which automatically makes it 48dp, because I did not want the image to be clickable. The whole card should be.
                    Icon(content.icon, contentDescription = stringResource(id = content.contentDescription), modifier = Modifier.height(48.dp))
                    Text(content.title, style = Typography.body1)
                }
            }
        }
    }
}
