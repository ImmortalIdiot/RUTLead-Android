package com.immortalidiot.rutlead.components.login

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import com.immortalidiot.rutlead.R
import com.immortalidiot.rutlead.ui.theme.darkWhite
import com.immortalidiot.rutlead.ui.theme.boldInter14

@Composable
fun AccountMissing() {
    Text(
        text = stringResource(id = R.string.account_missing),
        style = boldInter14,
        color = if (isSystemInDarkTheme()) darkWhite
        else Color.White
    )
}