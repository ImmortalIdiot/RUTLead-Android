package com.immortalidiot.rutlead.navigation.main

import androidx.compose.runtime.Immutable

@Immutable
sealed class RUTLeadScreen (val route: String) {
    object AuthScreenFlow: RUTLeadScreen("Auth")
}
