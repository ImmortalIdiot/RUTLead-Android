package com.immortalidiot.rutlead.navigation.navBars

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.ui.graphics.vector.ImageVector
import com.immortalidiot.rutlead.navigation.main.MainScreen


sealed class NavigationBarItem(
    val route: String,
    val name: String,
    val icon: ImageVector
) {

    // TODO(): replace icons from drawable folder

    object Journal : NavigationBarItem(
        route = MainScreen.JournalScreen.route,
        name = "Журнал",
        icon = Icons.Default.FavoriteBorder
    )

    object Profile : NavigationBarItem(
        route = MainScreen.ProfileScreen.route,
        name = "Профиль",
        icon = Icons.Default.FavoriteBorder
    )

    object Settings : NavigationBarItem(
        route = MainScreen.SettingsScreen.route,
        name = "Настройки",
        icon = Icons.Default.FavoriteBorder
    )
}
