package com.immortalidiot.rutlead

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.immortalidiot.rutlead.ui.theme.RUTLeadTheme
import com.immortalidiot.rutlead.screens.LoginDesign

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RUTLeadTheme {
                LoginDesign()
            }
        }
    }
}
