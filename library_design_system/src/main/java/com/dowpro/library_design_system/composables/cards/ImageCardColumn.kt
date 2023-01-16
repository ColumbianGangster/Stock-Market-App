package com.dowpro.library_design_system.composables.cards

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dowpro.library_design_system.R
import com.google.accompanist.pager.ExperimentalPagerApi

data class IconCardColumnContent(val title: String, val body: String, val iconId: Int, val contentDescription: Int)

@Composable
fun IconCardColumn(content: IconCardColumnContent) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Image(
            painter = painterResource(id = content.iconId),
            contentDescription = stringResource(id = content.contentDescription),
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(200.dp)
                .clip(CircleShape)
        )
        Column {
            Text(content.title)
            Text(content.body)
        }
    }
}

@OptIn(ExperimentalPagerApi::class)
@Preview(showBackground = true)
@Composable
private fun Preview() {
    IconCardColumn(content = IconCardColumnContent("Title", "Body", android.R.drawable.gallery_thumb, R.string.placeholder))
}