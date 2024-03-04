package com.immortalidiot.rutlead.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.text.selection.TextSelectionColors
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

val DarkColorScheme = darkColorScheme(
    primary = ThemeColors.Dark.primary,
    surface = ThemeColors.Dark.surface,
    outline = ThemeColors.Dark.outline,
    primaryContainer = ThemeColors.Dark.container,
    onSecondary = ThemeColors.Dark.text,
    onTertiary = ThemeColors.Dark.label,
    onPrimaryContainer = ThemeColors.Dark.container,
    onSecondaryContainer = ThemeColors.Dark.buttonOutline,
    scrim = ThemeColors.Dark.handle,
    onBackground = ThemeColors.Dark.textSelection

)

val LightColorScheme = lightColorScheme(
    primary = ThemeColors.Light.primary,
    surface = ThemeColors.Light.surface,
    outline = ThemeColors.Light.outline,
    primaryContainer = ThemeColors.Light.container,
    onSecondary = ThemeColors.Light.text,
    onTertiary = ThemeColors.Light.label,
    onPrimaryContainer = ThemeColors.Light.container,
    onSecondaryContainer = ThemeColors.Light.buttonOutline,
    scrim = ThemeColors.Light.handle,
    onBackground = ThemeColors.Light.textSelection

)



@Composable
fun RUTLeadTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) DarkColorScheme else LightColorScheme
        }

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }
    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            window.statusBarColor = colorScheme.primary.toArgb()
            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = darkTheme
        }
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}