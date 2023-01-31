package com.dowpro.library_design_system.composables.cards

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.dowpro.library_design_system.theme.Typography

data class ReadableImageCardContent(val url: String, val contentDescription: String, val body: String)

@Composable
fun HalfScreenBox(modifier: Modifier = Modifier, content: @Composable () -> Unit) {
    Box(modifier = Modifier.fillMaxWidth(0.5f).then(modifier)) {
        content.invoke()
    }
}

@Composable
fun AlignBottomStartBox(content: @Composable () -> Unit) {
    Box(modifier = Modifier.fillMaxSize().padding(12.dp), contentAlignment = Alignment.BottomStart) {
        content.invoke()
    }
}

@Composable
fun ReadableImageCard(content: ReadableImageCardContent, modifier: Modifier = Modifier, shape: Shape = RoundedCornerShape(16.dp), readable: Boolean = true) {
    Card (modifier = modifier.fillMaxWidth(), shape = shape) {
        // Used to stack the Image, Gradient and Text bottom to top in that order
        Box(modifier = Modifier.height(200.dp)) {
            AsyncImage(model = content.url, contentDescription = content.contentDescription, contentScale = ContentScale.Crop)
            Box (modifier = Modifier.fillMaxSize().background(brush = Brush.verticalGradient(listOf(Color.Transparent, if(readable) Color.Black else Color.Transparent))))
            AlignBottomStartBox {
                Text(text = content.body, style = Typography.headlineSmall.copy(color = Color.White))
            }
        }
    }
}
