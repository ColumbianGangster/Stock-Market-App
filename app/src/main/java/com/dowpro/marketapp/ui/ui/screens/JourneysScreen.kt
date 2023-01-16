package com.dowpro.marketapp.ui.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.dowpro.library_design_system.composables.buttons.PrimaryButton
import com.dowpro.library_design_system.composables.text.PrimaryText

@Composable
fun JourneysScreen(padding: PaddingValues = PaddingValues()) {
    Column(
        modifier = Modifier
            .padding(padding)
            .fillMaxSize()
    ) {
        PrimaryText(text = "When buttons are stacked you should use square buttons")
        PrimaryButton(text = "Dynamic List Screen") {

        }
        PrimaryButton(text = "Detail Screen") {

        }
        PrimaryButton(text = "Collapsing Toolbar Screen") {

        }
    }
}

@Preview(showBackground = true)
@Composable
fun BooksScreenPreview() {
    JourneysScreen()
}