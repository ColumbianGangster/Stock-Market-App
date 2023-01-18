package com.dowpro.feature_red

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.dowpro.library_design_system.composables.buttons.PrimaryRoundedButton
import com.dowpro.library_design_system.composables.scaffolds.MyStickyNoToolbarScaffold
import com.dowpro.library_design_system.composables.text.PrimaryText
import com.dowpro.library_design_system.theme.AppMaterialTheme
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
            AppMaterialTheme {
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
                    PrimaryRoundedButton(text = getString(R.string.red_pager_primary_cta), modifier = Modifier.padding(bottom = 24.dp)) {
                        finish()
                    }
                })
            }
        }
    }
}

@Composable
fun PageScreen(content: OnboardingTabItem) {
    Column(modifier = Modifier
        .fillMaxWidth()
        .fillMaxHeight()) {
        Box(
            modifier = Modifier
                .background(
                    color = Color.Blue,
                    shape = CutCornerShape(bottomEndPercent = 75),
                )
                .fillMaxWidth()
                .fillMaxHeight(0.5f)
        ) {
            CircleBorderStroke(400.dp) {
                CircleBorderStroke (300.dp) {
                    CircleBorderStroke (225.dp) {
                        CircleBorderStroke (150.dp) {
                            Box(modifier = Modifier
                                .padding(16.dp)
                                .background(shape = CircleShape, color = Color.LightGray)
                                .height(90.dp)
                                .width(90.dp)
                                .align(Alignment.BottomEnd))
                        }
                    }
                }
            }
        }
        PrimaryText(text = stringResource(content.title), style = Typography.h3)
        PrimaryText(text = stringResource(content.body), style = Typography.h5)
    }
}

@Composable
fun BoxScope.CircleBorderStroke(size: Dp, content: @Composable () -> Unit) {
    Box(modifier = Modifier
        .padding(16.dp)
        .background(shape = CircleShape, color = Color.Transparent)
        .border(width = 2.dp, color = Color.LightGray, shape = CircleShape)
        .height(size)
        .width(size)
        .align(Alignment.BottomEnd)) { content.invoke() }
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

sealed class OnboardingTabItem(val title: Int, val body: Int, val screen: @Composable (OnboardingTabItem) -> Unit) {
    data class Introducing(val padding: PaddingValues = PaddingValues()) :
        OnboardingTabItem(
            title = R.string.pager_title_first,
            body = R.string.pager_body_first,
            screen = { PageScreen(content = it) })

    data class MoreDetails(val padding: PaddingValues = PaddingValues()) :
        OnboardingTabItem(
            title = R.string.pager_title_second,
            body = R.string.pager_body_second,
            screen = { PageScreen(content = it) })
}