package com.dowpro.feature_red.ui

import android.content.Intent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.dowpro.feature_red.R
import com.dowpro.library_design_system.composables.buttons.PrimaryButton
import com.dowpro.library_design_system.composables.text.PrimaryText

@Composable
fun MockedJourneysScreen(padding: PaddingValues = PaddingValues()) {
    Column(
        modifier = Modifier
            .padding(padding)
            .fillMaxSize()
    ) {
        val context = LocalContext.current
        PrimaryText(text = stringResource(R.string.red_journeys_advice))
        PrimaryButton(text = stringResource(R.string.red_journeys_simple_lazy_column_screen)) {
            context.startActivity(Intent(context, RedListActivity::class.java))
        }
        PrimaryButton(text = stringResource(R.string.red_journeys_simple_lazy_row_screen)) {
            context.startActivity(Intent(context, RedRowActivity::class.java))
        }
        PrimaryButton(text = stringResource(R.string.red_journeys_async_image_lazy_column_screen)) {
            context.startActivity(Intent(context, RedAsyncImageColumnActivity::class.java))
        }
        PrimaryButton(text = stringResource(R.string.red_journeys_sticky_button_list_screen)) {
            context.startActivity(Intent(context, RedStickyButtonListActivity::class.java))
        }
        PrimaryButton(text = stringResource(R.string.red_journeys_pager_screen)) {
            context.startActivity(Intent(context, RedPagerActivity::class.java))
        }
        PrimaryButton(text = stringResource(R.string.red_journeys_readable_image_card_screen)) {
            context.startActivity(Intent(context, RedReadableImageCardActivity::class.java))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MockedJourneysScreenPreview() {
    MockedJourneysScreen()
}