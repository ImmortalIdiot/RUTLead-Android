package com.immortalidiot.rutlead.presentation.screens.main

import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.immortalidiot.rutlead.ui.theme.ThemeColors

@Composable
fun ProfileScreen(
    modifier: Modifier = Modifier,
    navController: NavHostController
) {
    val palette = if (isSystemInDarkTheme()) ThemeColors.Dark else ThemeColors.Light

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(palette.backgroundScreen),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Профиль")
    }
}

@Preview
@Composable
fun ProfileScreenPreview() {
    ProfileScreen(navController = rememberNavController())
}
