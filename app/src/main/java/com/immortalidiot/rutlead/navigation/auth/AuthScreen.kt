package com.immortalidiot.rutlead.navigation.auth

import androidx.compose.runtime.Immutable

@Immutable
sealed class AuthScreen(val route: String) {
    object LoginScreen: AuthScreen("Login")
    object SignUpScreen: AuthScreen("SignUp")
}
