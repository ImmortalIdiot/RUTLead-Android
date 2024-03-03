package com.immortalidiot.rutlead.fields

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import com.immortalidiot.rutlead.R
import com.immortalidiot.rutlead.ui.theme.boldInter14

@Composable
fun AccountMissing() {
    Text(
        text = stringResource(id = R.string.account_missing),
        style = boldInter14,
        color = MaterialTheme.colorScheme.surface
    )
}