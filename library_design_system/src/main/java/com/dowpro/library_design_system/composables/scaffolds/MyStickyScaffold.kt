package com.dowpro.library_design_system.composables.scaffolds

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.dowpro.library_design_system.composables.other.MarketTopAppBar

@Composable
fun MyStickyScaffold(title: Int, closeable: Boolean = false, content: @Composable (PaddingValues) -> Unit, stickyContent: @Composable () -> Unit) {
    Scaffold(
        topBar = {
            MarketTopAppBar(stringResource(title), closeable)
        }, content = {
            content.invoke(it)
        },
        bottomBar = {
            stickyContent.invoke()
        }
    )
}