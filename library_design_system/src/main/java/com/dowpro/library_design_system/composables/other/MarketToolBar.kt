package com.dowpro.library_design_system.composables.other

import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.dowpro.library_design_system.R

@Composable
fun MarketTopAppBar(title: String, closeable: Boolean, f: (() -> Unit)? = null) {
    TopAppBar(
        title = {
            Text(text = title)
        },
        navigationIcon = if (closeable) {
            {
                IconButton(onClick = { f?.invoke() }) {
                    Icon(Icons.Filled.Close, stringResource(R.string.content_description_close))
                }
            }
        } else null,
        backgroundColor = Color.Blue,
        contentColor = Color.White,
        elevation = 12.dp
    )
}
