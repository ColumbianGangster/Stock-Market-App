package com.dowpro.library_design_system.composables.scaffolds

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable

@Composable
fun MyStickyNoToolbarScaffold(closeable: Boolean = false, content: @Composable (PaddingValues) -> Unit, stickyContent: @Composable () -> Unit) {
    Scaffold(content = {
            content.invoke(it)
        },
        bottomBar = {
            stickyContent.invoke()
        }
    )
}