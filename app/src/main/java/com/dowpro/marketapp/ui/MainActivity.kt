package com.dowpro.marketapp.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.dowpro.library_design_system.composables.scaffolds.TopAppBarScaffold
import com.dowpro.library_design_system.theme.AppMaterialTheme
import com.dowpro.marketapp.R
import com.dowpro.marketapp.ui.main.tabs.HomeTabItem
import com.dowpro.marketapp.ui.main.tabs.Tabs
import com.dowpro.marketapp.ui.main.tabs.TabsHorizontalPager
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.rememberPagerState


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppMaterialTheme {
                MainScreen()
            }
        }
    }
}

@OptIn(ExperimentalPagerApi::class)
@Composable
fun MainScreen() {
    val pagerState = rememberPagerState()
    TopAppBarScaffold(R.string.appbar_title_main, false) { padding ->
        Column(modifier = Modifier.padding(padding)) {
            val tabs = listOf(HomeTabItem.DesignLibrary(padding), HomeTabItem.FeatureDemo(padding), HomeTabItem.MockedJourneys(padding))
            Tabs(tabs = tabs, pagerState = pagerState)
            TabsHorizontalPager(tabs = tabs, pagerState = pagerState)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    MainScreen()
}