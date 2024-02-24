package com.immortalidiot.rutlead.ui.providers

import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Stable

@Stable
suspend fun SnackbarHostState.showMessage(message: String) {
    showSnackbar(
        message = message,
        withDismissAction = true,
        duration = SnackbarDuration.Indefinite
    )
}