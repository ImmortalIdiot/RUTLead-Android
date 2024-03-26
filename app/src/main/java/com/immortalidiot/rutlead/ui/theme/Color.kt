package com.immortalidiot.rutlead.ui.theme

import androidx.compose.ui.graphics.Color

val DarkWhite = Color(0xFFC7D2E5)
val ClassicWhite = Color.White

val PrimaryDarkBlue = Color(0xFF1E4A99)
val DarkBlue = Color(0xFF2552A3)
val LightBlue = Color(0xFF2A5EBD)

val ClassicGray = Color.Gray
val DarkGray = Color.DarkGray
val LightGray = Color.LightGray
val DarkLightGray = Color(0xFF878787)

val DarkBlack = Color(0xFF1C1B1B)
val LightBlack = Color(0xFF232323)

val LightRed = Color(0xFFFF5454)
val DarkRed = Color(0xFF51221f)

sealed class ThemeColors(
    val header: Color,
    val surface: Color,
    val backgroundScreen: Color,
    val primary: Color,
    val content: Color,
    val outline: Color,
    val text: Color,
    val containerText: Color,
    val container: Color,
    val containerColorError: Color,
    val textColorError: Color,
    val label: Color,
    val labelText: Color,
    val cursor: Color,
    val buttonOutline: Color,
    val textSelection: Color,
    val handle: Color,
    val handleBackground: Color,
    val indicatorNavBar: Color,
    val textNavBar: Color
) {
    object Light : ThemeColors(
        header = ClassicWhite,
        surface = ClassicWhite,
        primary = LightBlue,
        backgroundScreen = Color.Transparent,
        content = LightBlue,
        outline = Color.Transparent,
        text = ClassicWhite,
        container = ClassicWhite,
        containerText = LightBlue,
        containerColorError = LightRed,
        textColorError = Color.White,
        label = ClassicWhite,
        labelText = LightBlue,
        cursor = LightBlue,
        buttonOutline = Color.White,
        textSelection = DarkWhite,
        handle = LightGray,
        handleBackground = LightGray,
        indicatorNavBar = ClassicWhite,
        textNavBar = LightBlue
    )

    object Dark : ThemeColors(
        header = DarkWhite,
        surface = DarkBlack,
        primary = LightBlack,
        backgroundScreen = DarkBlack,
        content = DarkWhite,
        outline = PrimaryDarkBlue,
        text = DarkWhite,
        container = LightBlack,
        containerText = DarkWhite,
        containerColorError = DarkRed,
        textColorError = DarkWhite,
        label = DarkWhite,
        labelText = DarkWhite,
        cursor = DarkBlue,
        buttonOutline = DarkBlue,
        textSelection = PrimaryDarkBlue,
        handle = DarkWhite,
        handleBackground = LightBlue,
        indicatorNavBar = DarkBlack,
        textNavBar = DarkLightGray
    )
}
