package com.dowpro.library_design_system.composables.cards

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.dowpro.library_design_system.theme.Typography

data class AsyncImageCardContent(val url: String, val contentDescription: Int, val title: String, val body: String)

@Composable
fun AsyncImageLazyColumn(contents: List<AsyncImageCardContent>) {
    LazyColumn {
        items(contents) { content ->
            AsyncImageCard(content)
        }
    }
    Spacer(Modifier.size(90.dp))
}

@Composable
fun AsyncImageCard(content: AsyncImageCardContent) {
    Card(modifier = Modifier
        .padding(8.dp)
        .fillMaxWidth()) {
        Row(modifier = Modifier.padding(8.dp)) {
            AsyncImage(
                model = content.url,
                contentDescription = stringResource(id = content.contentDescription),
                modifier = Modifier
                    .size(90.dp)
                    .clip(CircleShape)
                    .align(Alignment.CenterVertically),
                contentScale = ContentScale.Crop,
            )
            Column(modifier = Modifier.padding(start = 8.dp)) {
                Text(text = content.title, style = Typography.h5)
                Text(text = content.body)
            }
        }
    }
}

@Composable
fun AsyncImageBox(url: String, contentDescription: Int) {
    AsyncImage(
        model = url,
        contentDescription = stringResource(id = contentDescription),
        modifier = Modifier.fillMaxWidth(),
        contentScale = ContentScale.Crop,
    )
}