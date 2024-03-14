package com.immortalidiot.rutlead

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.immortalidiot.rutlead.providers.LocalSnackbarHostState
import com.immortalidiot.rutlead.screens.LoginDesign
import com.immortalidiot.rutlead.ui.theme.RUTLeadTheme
import com.immortalidiot.rutlead.viewmodels.LoginScreenViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RUTLeadTheme {
                val snackbarHostState = remember { SnackbarHostState() }
                CompositionLocalProvider(LocalSnackbarHostState provides snackbarHostState) {
                    LoginDesign(
                        modifier = Modifier,
                        viewModel = LoginScreenViewModel(),
                    )
                }
            }
        }
    }
}
