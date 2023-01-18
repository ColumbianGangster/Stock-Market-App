package com.dowpro.feature_red

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Favorite
import androidx.compose.material.icons.rounded.Help
import androidx.compose.material.icons.rounded.Info
import androidx.compose.material.icons.rounded.Settings
import com.dowpro.library_design_system.composables.cards.IconCardLazyRow
import com.dowpro.library_design_system.composables.cards.RowContent
import com.dowpro.library_design_system.composables.scaffolds.TopAppBarScaffold
import com.dowpro.library_design_system.theme.AppMaterialTheme

class RedRowActivity: ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppMaterialTheme {
                TopAppBarScaffold(R.string.red_title, true) {
                    IconCardLazyRow(contents = listOf(
                        RowContent("Help", Icons.Rounded.Help, R.string.content_description_help),
                        RowContent("Settings", Icons.Rounded.Settings, R.string.content_description_settings),
                        RowContent("Favourite", Icons.Rounded.Favorite, R.string.content_description_favourite),
                        RowContent("Legal", Icons.Rounded.Info, R.string.content_description_legal),
                    ))
                }
            }
        }
    }
}

