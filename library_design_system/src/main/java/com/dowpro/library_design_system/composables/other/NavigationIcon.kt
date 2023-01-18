package com.dowpro.library_design_system.composables.other

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.dowpro.library_design_system.R

@Composable
fun NavigationIcon() {
    IconButton(
        onClick = {  }) {
        Icon(
            imageVector = Icons.Filled.ArrowBack,
            contentDescription = stringResource(id = R.string.navigate_back)
        )
    }
}

@Composable
fun AboutActionIcon() {
    IconButton(
        onClick = {  }) {
        Icon(
            imageVector = Icons.Filled.Info,
            contentDescription = stringResource(id = R.string.navigate_about)
        )
    }
}