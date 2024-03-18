package com.immortalidiot.rutlead.providers

import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Stable
import androidx.compose.runtime.compositionLocalOf

val LocalSnackbarHostState =
    compositionLocalOf<SnackbarHostState> { error("SnackbarHostState is not initialized") }

@Stable
suspend fun SnackbarHostState.showMessage(message: String) {
    showSnackbar(
        message = message,
        withDismissAction = true,
        duration = SnackbarDuration.Long
    )
}
