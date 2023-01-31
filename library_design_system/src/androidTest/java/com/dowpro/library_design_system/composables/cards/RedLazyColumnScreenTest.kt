package com.dowpro.library_design_system.composables.cards

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import com.dowpro.library_design_system.composables.scaffolds.TopAppBarScaffold
import com.dowpro.library_design_system.data.MockCreator
import com.dowpro.library_design_system.theme.AppMaterialTheme
import org.junit.Rule
import org.junit.Test

class RedLazyColumnScreenTest {

    @get:Rule
    val composeTestRule = createComposeRule()
    // use createAndroidComposeRule<YourActivity>() if you need access to
    // an activity

    @Test
    fun checkInteractions() {
        // Start the app
        composeTestRule.setContent {
            AppMaterialTheme {
                TopAppBarScaffold(android.R.string.untitled, true) {
                    RedLazyColumnScreen(contents = MockCreator.lazyColumnScreenContents())
                }
            }
        }

        composeTestRule.onNodeWithText("Title 1").performClick()
        composeTestRule.onNodeWithText("Title 2").performClick()
        composeTestRule.onNodeWithText("Title 3").performClick()
    }
}