package com.dowpro.marketapp.ui.ui.screens

import android.content.Intent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.dowpro.feature_red.*
import com.dowpro.library_design_system.composables.buttons.PrimaryButton
import com.dowpro.library_design_system.composables.text.PrimaryText

@Composable
fun JourneysScreen(padding: PaddingValues = PaddingValues()) {
    Column(
        modifier = Modifier
            .padding(padding)
            .fillMaxSize()
    ) {
        val context = LocalContext.current
        PrimaryText(text = "When buttons are stacked you should use square buttons")
        PrimaryButton(text = "Simple Lazy Column Screen") {
            context.startActivity(Intent(context, RedListActivity::class.java))
        }
        PrimaryButton(text = "Simple Lazy Row Screen") {
            context.startActivity(Intent(context, RedRowActivity::class.java))
        }
        PrimaryButton(text = "Async Image Lazy Column Screen") {
            context.startActivity(Intent(context, RedAsyncImageColumnActivity::class.java))
        }
        PrimaryButton(text = "Sticky Button List Screen") {
            context.startActivity(Intent(context, RedStickyButtonListActivity::class.java))
        }
        PrimaryButton(text = "Pager Screen") {
            context.startActivity(Intent(context, RedPagerActivity::class.java))
        }
        PrimaryButton(text = "Readable Image Card") {
            context.startActivity(Intent(context, RedReadableImageCardActivity::class.java))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BooksScreenPreview() {
    JourneysScreen()
}