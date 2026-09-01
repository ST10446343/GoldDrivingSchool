package com.example.golddrivingschool.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Typography
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

private val GoldColorScheme = lightColorScheme(

    primary = Gold,
    onPrimary = Dark,

    secondary = GoldDark,
    onSecondary = White,

    background = LightBackground,
    onBackground = Dark,

    surface = White,
    onSurface = Dark,

    error = ErrorRed,
    onError = White
)

private val AppTypography = Typography()

@Composable
fun GoldDrivingSchoolTheme(
    content: @Composable () -> Unit
) {

    MaterialTheme(
        colorScheme = GoldColorScheme,
        typography = AppTypography,
        content = content
    )
}