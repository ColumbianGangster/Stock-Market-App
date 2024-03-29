package com.dowpro.feature_red.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Modifier
import com.dowpro.feature_red.R
import com.dowpro.feature_red.data.MockCreator
import com.dowpro.library_design_system.composables.buttons.PrimaryRoundedButton
import com.dowpro.library_design_system.composables.cards.RedLazyColumnScreen
import com.dowpro.library_design_system.composables.scaffolds.MyStickyScaffold
import com.dowpro.library_design_system.theme.AppMaterialTheme

class RedStickyButtonListActivity: ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppMaterialTheme {
                MyStickyScaffold(
                    title = R.string.red_title,
                    closeable = true,
                    content = {
                        RedLazyColumnScreen(modifier = Modifier.padding(it), contents = MockCreator.stickyButtonListContent())
                    },
                    stickyContent = {
                        PrimaryRoundedButton(text = getString(R.string.red_sticky_button_list_cta)) {
                            finish()
                        }
                    })
            }
        }
    }
}