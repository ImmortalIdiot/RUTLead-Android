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
    val verticalXXLLarge: Dp = 40.dp,
    val verticalXXXLLarge: Dp = 80.dp,

    val verticalSmallPadding: Dp = 4.dp,
    val verticalNormalPadding: Dp = 6.dp,
    val verticalSLargePadding: Dp = 16.dp,
    val verticalXLargePadding: Dp = 24.dp,
    val verticalXLLargePadding: Dp = 32.dp,

    val horizontalSSmall: Dp = 8.dp,
    val horizontalStandard: Dp = 20.dp,

    val roundedStandard: Dp = 12.dp,
)

val LocalDimensions = compositionLocalOf { Dimensions() }
