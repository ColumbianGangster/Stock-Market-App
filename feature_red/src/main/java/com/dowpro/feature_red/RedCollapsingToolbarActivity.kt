package com.dowpro.feature_red

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.dowpro.library_design_system.composables.scaffolds.CollapsingToolbarScaffold
import com.dowpro.library_design_system.theme.AppMaterialTheme

class RedCollapsingToolbarActivity: ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppMaterialTheme {
                CollapsingToolbarScaffold(R.string.red_title) {

                }
            }
        }
    }
}