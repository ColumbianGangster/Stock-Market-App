package com.dowpro.marketapp.ui.ui.tabs

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Book
import androidx.compose.material.icons.filled.Movie
import androidx.compose.material.icons.filled.MusicNote
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import com.dowpro.marketapp.ui.ui.screens.BooksScreen
import com.dowpro.marketapp.ui.ui.screens.MoviesScreen
import com.dowpro.marketapp.ui.ui.screens.DesignScreen

sealed class TabItem(var icon: ImageVector, var title: String, var screen: @Composable () -> Unit) {
    object Design : TabItem(Icons.Filled.MusicNote, "Design M2", { DesignScreen() })
    object Movies : TabItem(Icons.Filled.Movie, "Design M3", { MoviesScreen() })
    object Books : TabItem(Icons.Filled.Book, "Dev", { BooksScreen() })
}