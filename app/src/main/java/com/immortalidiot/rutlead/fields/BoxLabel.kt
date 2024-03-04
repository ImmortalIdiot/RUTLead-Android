package com.immortalidiot.rutlead.fields

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import com.immortalidiot.rutlead.ui.theme.DarkWhite
import com.immortalidiot.rutlead.ui.theme.mediumInter32

@Composable
fun BoxLabel() {
    Text(
        text = "Авторизация",
        modifier = Modifier.fillMaxWidth(),
        color = MaterialTheme.colorScheme.onTertiary,
        textAlign = TextAlign.Center,
        style = mediumInter32
    )
}