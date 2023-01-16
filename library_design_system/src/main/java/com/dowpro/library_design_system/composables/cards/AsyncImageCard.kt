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
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.graphics.*
import androidx.compose.ui.graphics.drawscope.clipPath
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.dowpro.library_design_system.theme.Typography

data class AsyncImageCardContent(val url: String, val contentDescription: Int, val title: String, val body: String, val online: Boolean)

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
    // Credit to here:
    // https://developer.android.com/jetpack/compose/graphics/draw/modifiers
    val modifier = Modifier
        .graphicsLayer {
            // Rendering of content will always be rendered into an offscreen buffer first
            // then drawn to the destination regardless of the other parameters configured on the graphics layer.
            // Unfortunately, the transparency fails without this.
            compositingStrategy = CompositingStrategy.Offscreen
        }
        .drawWithCache {
            val path = Path()
            path.addOval(
                Rect(
                    topLeft = Offset.Zero,
                    bottomRight = Offset(size.width, size.height)
                )
            )
            onDrawWithContent {
                clipPath(path) {
                    this@onDrawWithContent.drawContent()
                }
                val dotSize = size.width / 8f
                drawCircle(
                    Color.Black,
                    radius = dotSize,
                    center = Offset(
                        x = size.width - dotSize,
                        y = size.height - dotSize
                    ),
                    blendMode = BlendMode.Clear
                )
                drawCircle(
                    Color(if(content.online) Color.Green.toArgb() else Color.Red.toArgb()), radius = dotSize * 0.8f,
                    center = Offset(
                        x = size.width - dotSize,
                        y = size.height - dotSize
                    )
                )
            }
        }

    Card(modifier = Modifier
        .padding(8.dp)
        .fillMaxWidth()) {
        Row(modifier = Modifier.padding(8.dp)) {
            AsyncImage(
                model = content.url,
                contentDescription = stringResource(id = content.contentDescription),
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(90.dp)
                    .align(Alignment.CenterVertically)
                    .padding(8.dp)
                    .then(modifier),
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