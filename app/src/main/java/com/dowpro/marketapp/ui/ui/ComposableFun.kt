package com.dowpro.marketapp.ui.ui

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Book
import androidx.compose.material.icons.filled.Movie
import androidx.compose.material.icons.filled.MusicNote
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import com.dowpro.marketapp.ui.BooksScreen
import com.dowpro.marketapp.ui.MoviesScreen
import com.dowpro.marketapp.ui.MusicScreen

typealias ComposableFun = @Composable () -> Unit

sealed class TabItem(var icon: ImageVector, var title: String, var screen: ComposableFun) {
    object Music : TabItem(Icons.Filled.MusicNote, "Music", { MusicScreen() })
    object Movies : TabItem(Icons.Filled.Movie, "Movies", { MoviesScreen() })
    object Books : TabItem(Icons.Filled.Book, "Books", { BooksScreen() })
}