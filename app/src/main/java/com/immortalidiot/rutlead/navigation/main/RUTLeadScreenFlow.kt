package com.immortalidiot.rutlead.navigation.main

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.immortalidiot.rutlead.navigation.auth.authScreenFlow

@Composable
fun RUTLeadScreenFlow(
    paddingValues: PaddingValues,
    isNavigationBarVisible: (Boolean) -> Unit,
    navController: NavHostController = rememberNavController()
) {
     NavHost(
         modifier = Modifier.padding(paddingValues = paddingValues),
         navController = navController,
         startDestination = RUTLeadScreen.AuthScreenFlow.route
     ) {
         authScreenFlow(navController = navController) { isNavigationBarVisible(false) }
     }
}
