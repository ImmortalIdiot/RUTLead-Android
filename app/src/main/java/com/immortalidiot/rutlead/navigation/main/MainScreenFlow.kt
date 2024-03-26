package com.immortalidiot.rutlead.navigation.main

import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.immortalidiot.rutlead.navigation.RUTLeadScreen

fun NavGraphBuilder.mainScreenFlow(
    navController: NavHostController
) {
    navigation(
        startDestination = MainScreen.JournalScreen.route,
        route = RUTLeadScreen.MainScreenFlow.route
    ) {
        composable(
            route = MainScreen.JournalScreen.route,
            enterTransition = { fadeIn() },
            exitTransition = { fadeOut() }
        ) {
            // TODO(): add journal screen
        }

        composable(
            route = MainScreen.ProfileScreen.route,
            enterTransition = { fadeIn() },
            exitTransition = { fadeOut() }
        ) {
            // TODO(): add profile screen
        }
    }
}