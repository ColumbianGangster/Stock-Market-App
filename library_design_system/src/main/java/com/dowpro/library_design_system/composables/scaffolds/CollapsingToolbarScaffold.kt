package com.dowpro.library_design_system.composables.scaffolds

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.dowpro.library_design_system.composables.other.AboutActionIcon
import com.dowpro.library_design_system.composables.other.NavigationIcon


// Credit: https://proandroiddev.com/creating-a-collapsing-topappbar-with-jetpack-compose-d25ad19d6113
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CollapsingToolbarScaffold(navController: NavHostController, title: String, content: @Composable (PaddingValues) -> Unit) {
    val scrollBehavior = TopAppBarDefaults.exitUntilCollapsedScrollBehavior(rememberTopAppBarState())
    val isCollapsed = remember { derivedStateOf { scrollBehavior.state.collapsedFraction > 0.5 } }

    val topAppBarElementColor = if (isCollapsed.value) { // TODO: Investigate .value
        MaterialTheme.colorScheme.onSurface
    } else {
        MaterialTheme.colorScheme.onPrimary
    }

    val collapsed = 22
    val expanded = 28

    val topAppBarTextSize = (collapsed + (expanded - collapsed)*(1-scrollBehavior.state.collapsedFraction)).sp

    Scaffold(
        topBar = {
            LargeTopAppBar(
                title = { Text(text = title, fontSize = topAppBarTextSize) },
                navigationIcon = { NavigationIcon(navController = navController) },
                actions = { AboutActionIcon(navController) },
                scrollBehavior = scrollBehavior,
                colors = TopAppBarDefaults.largeTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    scrolledContainerColor = MaterialTheme.colorScheme.surface,
                    navigationIconContentColor = topAppBarElementColor,
                    titleContentColor = topAppBarElementColor,
                    actionIconContentColor= topAppBarElementColor,
                ),
            )
        },
        modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection)
    ) { innerPadding ->
        content(innerPadding)
    }
}
