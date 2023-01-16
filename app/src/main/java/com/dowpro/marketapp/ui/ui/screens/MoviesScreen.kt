package com.dowpro.marketapp.ui.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.dowpro.library_design_system.composables.buttons.PrimaryRoundedButton

@Composable
fun MoviesScreen(paddingValues: PaddingValues = PaddingValues()) {
    Column(
        modifier = Modifier
            .padding(paddingValues)
            .fillMaxSize()
            .background(Color.White)
            .wrapContentSize(Alignment.Center)
    ) {
        PrimaryRoundedButton("Pokemon List") {

        }
    }
}

@Preview(showBackground = true)
@Composable
fun MoviesScreenPreview() {
    MoviesScreen()
}