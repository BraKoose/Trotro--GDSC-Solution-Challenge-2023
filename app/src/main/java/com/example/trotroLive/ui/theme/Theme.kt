package com.example.trotroLive.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable

private val LightColorPalette = lightColors(
    primary = Primary,
    secondary = Secondary,
    surface = SecondaryShade,
    onPrimary = Black,
    onError = Warning,
    onSurface = SecondaryVariant,
    onBackground = Black
)

private val DarkColorPalette = darkColors(
    //
primary = PrimaryDark,
    secondary = SecondaryShade,
    surface = Black,
    onPrimary = Info,
    onError = Warning,
    error = Warning,
    onSurface = SecondaryVariant,
    onBackground = PrimaryDark
)

@Composable
fun TrotroTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colors = if (darkTheme) DarkColorPalette else LightColorPalette,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}