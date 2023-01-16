package com.dowpro.library_design_system.composables.other

import android.app.Activity
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.dowpro.library_design_system.R

@Composable
fun MarketTopAppBar(title: String, closeable: Boolean) {
    TopAppBar(
        title = {
            Text(text = title)
        },
        navigationIcon = if (closeable) {
            {
                // Compose initializes ComposeView with activity(this) in setContent, gets context
                // from it, and provides it as LocalContext. So LocalContext.current as Activity is safe.
                val context = LocalContext.current as Activity
                IconButton(onClick = { context.finish() }) {
                    Icon(Icons.Filled.Close, stringResource(R.string.content_description_close))
                }
            }
        } else null,
        backgroundColor = Color.Blue,
        contentColor = Color.White,
        elevation = 12.dp
    )
}
