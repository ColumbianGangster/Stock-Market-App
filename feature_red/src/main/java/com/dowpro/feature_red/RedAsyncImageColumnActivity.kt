package com.dowpro.feature_red

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.dowpro.library_design_system.composables.cards.AsyncImageCardContent
import com.dowpro.library_design_system.composables.cards.AsyncImageLazyColumn
import com.dowpro.library_design_system.composables.scaffolds.TopAppBarScaffold
import com.dowpro.library_design_system.theme.AppMaterialTheme

class RedAsyncImageColumnActivity: ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppMaterialTheme {
                TopAppBarScaffold(R.string.red_title, true) {
                    AsyncImageLazyColumn(contents = MockCreator.asyncImageCardContentList())
                }
            }
        }
    }
}
