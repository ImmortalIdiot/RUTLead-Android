package com.immortalidiot.rutlead

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.remember
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import com.immortalidiot.rutlead.providers.LocalSnackbarHostState
import com.immortalidiot.rutlead.screens.LoginDesign
import com.immortalidiot.rutlead.ui.theme.RUTLeadTheme
import com.immortalidiot.rutlead.ui.theme.ThemeColors
import com.immortalidiot.rutlead.viewmodels.LoginScreenViewModel

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalComposeUiApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RUTLeadTheme {
                val snackbarHostState = remember { SnackbarHostState() }

                val keyboardController = LocalSoftwareKeyboardController.current

                val palette = if (isSystemInDarkTheme()) ThemeColors.Dark
                else ThemeColors.Light

                CompositionLocalProvider(LocalSnackbarHostState provides snackbarHostState) {
                    LoginDesign(
                        modifier = Modifier.pointerInput(Unit) {
                            detectTapGestures(
                                onTap = {
                                    keyboardController?.hide()
                                }
                            )
                        },
                        viewModel = LoginScreenViewModel(),
                        palette = palette
                    )
                }
            }
        }
    }
}
