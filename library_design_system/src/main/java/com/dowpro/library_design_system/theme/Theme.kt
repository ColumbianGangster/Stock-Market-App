package com.dowpro.library_design_system.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

val LocalCardElevation = staticCompositionLocalOf { Dp.Unspecified }

@Composable
fun AppMaterialTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val cardElevation = if (darkTheme) 4.dp else 0.dp
    CompositionLocalProvider(LocalCardElevation provides cardElevation) {

        // Dynamic color is the key part of Material You, in which an algorithm derives custom
        // colors from a user’s wallpaper to be applied to their apps and system UI.
        // This color palette is used as the starting point to generate light and dark color schemes.
        // Dynamic color is available on Android 12+
        val dynamicColor = Build.VERSION.SDK_INT >= Build.VERSION_CODES.S
        val colors = when {
            dynamicColor && darkTheme -> dynamicDarkColorScheme(LocalContext.current)
                    dynamicColor && !darkTheme -> dynamicLightColorScheme(LocalContext.current)
            darkTheme -> darkColorScheme()
                    else -> lightColorScheme()
        }

        MaterialTheme(
            colorScheme = colors,
            typography = Typography,
            content = content
        )
    }


}