package com.immortalidiot.rutlead.ui.theme

import androidx.compose.material3.ColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

val Purple80 = Color(0xFFD0BCFF)
val PurpleGrey80 = Color(0xFFCCC2DC)
val Pink80 = Color(0xFFEFB8C8)

val Purple40 = Color(0xFF6650a4)
val PurpleGrey40 = Color(0xFF625b71)
val Pink40 = Color(0xFF7D5260)

val classicWhite = Color.White
val classicBlack = Color.Black
val classicRed = Color.Red

val primaryGrayLightTheme = Color(0xFF878787)
val primaryGrayDarkTheme = Color(0xFFC8C8C8)
val DarkWhite = Color(0xFFC7D2E5)

val primaryDarkBlue = Color(0xFF1E4A99)
val DarkBlue = Color(0xFF2552A3)
val LightBlue = Color(0xFF2A5EBD)

val DarkBlack = Color(0xFF1C1B1B)
val LightBlack = Color(0xFF232323)

sealed class ThemeColors(
    val background: Color,
    val surface: Color,
    val primary: Color,
    val secondary: Color,
    val outline: Color,
    val text: Color
) {
    object Light: ThemeColors(
        background = Color.White,
        surface = Color.White,
        primary = LightBlue,
        secondary = DarkBlue,
        outline = Color.Transparent,
        text = LightBlue
    )
    object Dark: ThemeColors(
        background = LightBlack,
        surface = DarkBlack,
        primary = LightBlack,
        secondary = DarkBlue,
        outline = primaryDarkBlue,
        text = DarkWhite
    )
}