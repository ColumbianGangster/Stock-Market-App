package com.dowpro.marketapp.ui.ui.tabs

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Book
import androidx.compose.material.icons.filled.Movie
import androidx.compose.material.icons.filled.MusicNote
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import com.dowpro.marketapp.ui.ui.screens.DesignScreen
import com.dowpro.marketapp.ui.ui.screens.FeatureScreen
import com.dowpro.marketapp.ui.ui.screens.JourneysScreen
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.rememberPagerState

sealed class HomeTabItem(val icon: ImageVector, val title: String, val screen: @Composable () -> Unit) {
    data class DesignLibrary(val padding: PaddingValues = PaddingValues()) : HomeTabItem(Icons.Filled.MusicNote, "Design Library", { DesignScreen() })
    data class MockedJourneys(val padding: PaddingValues = PaddingValues()) : HomeTabItem(Icons.Filled.Book, "Mocked Journeys", { JourneysScreen(padding) })
    data class Feature(val padding: PaddingValues = PaddingValues()) : HomeTabItem(Icons.Filled.Movie, "Feature Home", { FeatureScreen(padding) })
}

@OptIn(ExperimentalPagerApi::class)
@Preview(showBackground = true)
@Composable
fun TabsContentPreview() {
    val tabs = listOf(
        HomeTabItem.DesignLibrary(),
        HomeTabItem.MockedJourneys(),
        HomeTabItem.Feature(),
    )
    val pagerState = rememberPagerState()
    TabsHorizontalPager(tabs = tabs, pagerState = pagerState)
}