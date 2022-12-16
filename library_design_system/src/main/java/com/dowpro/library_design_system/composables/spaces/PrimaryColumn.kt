package com.dowpro.library_design_system.composables.spaces

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun PrimaryScrollingColumn(modifier: Modifier = Modifier, content: @Composable (ColumnScope.() -> Unit)) {
    Column(modifier =
        modifier
            .padding(all = 8.dp)
            .fillMaxSize()
            .background(Color.White)
            .verticalScroll(rememberScrollState())
            , content = content
        )
}