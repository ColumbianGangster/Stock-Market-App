package com.dowpro.marketapp.ui.ui.tabs

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Book
import androidx.compose.material.icons.filled.Movie
import androidx.compose.material.icons.filled.MusicNote
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import com.dowpro.marketapp.ui.ui.screens.JourneysScreen
import com.dowpro.marketapp.ui.ui.screens.MoviesScreen
import com.dowpro.marketapp.ui.ui.screens.DesignScreen
import androidx.compose.ui.tooling.preview.Preview
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.rememberPagerState

sealed class HomeTabItem(val icon: ImageVector, val title: String, val screen: @Composable () -> Unit) {
    data class Design(val padding: PaddingValues = PaddingValues()) : HomeTabItem(Icons.Filled.MusicNote, "M2 Design Library", { DesignScreen(padding) })
    data class Movies(val padding: PaddingValues = PaddingValues()) : HomeTabItem(Icons.Filled.Movie, "Design M3", { MoviesScreen(padding) })
    data class Journeys(val padding: PaddingValues = PaddingValues()) : HomeTabItem(Icons.Filled.Book, "Journeys", { JourneysScreen(padding) })
}

@OptIn(ExperimentalPagerApi::class)
@Preview(showBackground = true)
@Composable
fun TabsContentPreview() {
    val tabs = listOf(
        HomeTabItem.Design(),
        HomeTabItem.Movies(),
        HomeTabItem.Journeys()
    )
    val pagerState = rememberPagerState()
    TabsHorizontalPager(tabs = tabs, pagerState = pagerState)
}