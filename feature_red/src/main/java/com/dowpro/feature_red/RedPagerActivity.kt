package com.dowpro.feature_red

import android.os.Build
import android.os.Bundle
import android.view.WindowInsetsController
import android.view.WindowManager
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.core.view.WindowCompat
import com.dowpro.library_design_system.composables.buttons.PrimaryRoundedButton
import com.dowpro.library_design_system.composables.scaffolds.MyStickyNoToolbarScaffold
import com.dowpro.library_design_system.composables.scaffolds.MyStickyScaffold
import com.dowpro.library_design_system.composables.text.PrimaryText
import com.dowpro.library_design_system.theme.MarketAppTheme
import com.dowpro.library_design_system.theme.Typography
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.PagerState
import com.google.accompanist.pager.rememberPagerState
import com.google.accompanist.systemuicontroller.SystemUiController
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@OptIn(ExperimentalPagerApi::class)
class RedPagerActivity: ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MarketAppTheme {
                val systemUiController: SystemUiController = rememberSystemUiController()
                DisposableEffect(systemUiController, false) {
                    systemUiController.setStatusBarColor(
                        color = Color.Blue,
                        darkIcons = false
                    )
                    onDispose {  }
                }

                MyStickyNoToolbarScaffold(true, {
                    val pagerState = rememberPagerState()
                    val tabs = listOf(OnboardingTabItem.Introducing(it), OnboardingTabItem.MoreDetails(it),)
                    OnboardingPager(tabs = tabs, pagerState = pagerState)
                }, {
                    PrimaryRoundedButton(text = "Next", modifier = Modifier.padding(bottom = 24.dp)) {
                        finish()
                    }
                })
            }
        }
    }
}

@Composable
fun PageScreen(paddingValues: PaddingValues, content: OnboardingTabItem) {
    Column(modifier = Modifier
        .fillMaxWidth()
        .fillMaxHeight()) {
        val gradient45 = Brush.linearGradient(
            colors = listOf(Color.Yellow, Color.Red),
            start = Offset(0f, Float.POSITIVE_INFINITY),
            end = Offset(Float.POSITIVE_INFINITY, 0f)
        )
        Box(
            modifier = Modifier
                .height(300.dp)
                .background(
                    Color.Blue
                )
                .fillMaxWidth()
        ) {

        }
        PrimaryText(text = content.title, style = Typography.h4)
        PrimaryText(text = content.body)
    }
}

@OptIn(ExperimentalPagerApi::class)
@Composable
fun OnboardingPager(tabs: List<OnboardingTabItem>, pagerState: PagerState) {
    HorizontalPager(state = pagerState, count = tabs.size, modifier = Modifier
        .fillMaxWidth()
        .fillMaxHeight()) { page ->
        tabs[page].screen(tabs[page])
    }
}

sealed class OnboardingTabItem(val contentDescription: Int, val title: String, val body: String, val screen: @Composable (OnboardingTabItem) -> Unit) {
    data class Introducing(val padding: PaddingValues = PaddingValues()) :
        OnboardingTabItem(
            contentDescription = 0,
            title = "Introducing Blockchain",
            body = "Your one-stop shop for all things blockchain",
            screen = { PageScreen(paddingValues = padding, content = it) })

    data class MoreDetails(val padding: PaddingValues = PaddingValues()) :
        OnboardingTabItem(
            contentDescription = 0,
            title = "See your entire ledger",
            body = "A blockchain is a distributed ledger with growing lists of records (blocks) that are securely linked together via cryptographic hashes.",
            screen = { PageScreen(paddingValues = padding, content = it) })
}