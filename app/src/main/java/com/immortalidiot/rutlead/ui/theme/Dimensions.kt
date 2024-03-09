package com.immortalidiot.rutlead.ui.theme

import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

data class Dimensions(
    val verticalSSmall: Dp = 8.dp,
    val verticalXSmall: Dp = 10.dp,
    val verticalNormal: Dp = 12.dp,
    val verticalStandard: Dp = 16.dp,
    val verticalSLarge: Dp = 20.dp,
    val verticalXLarge: Dp = 32.dp,
    val verticalXXLarge: Dp = 40.dp,

    val verticalSmallPadding: Dp = 4.dp,
    val verticalNormalPadding: Dp = 6.dp,

    val shapeSSmall: Dp = 2.dp,
    val shapeXSmall: Dp = 4.dp,
    val shapeNormal: Dp = 8.dp,
    val shapeSLarge: Dp = 10.dp,
    val shapeXLarge: Dp = 15.dp,

    val borderSSmall: Dp = 3.dp,
    val borderNormal: Dp = 5.dp,
    val borderXLarge: Dp = 8.dp
)

val LocalDimensions = compositionLocalOf { Dimensions() }
