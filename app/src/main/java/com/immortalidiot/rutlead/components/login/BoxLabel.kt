package com.immortalidiot.rutlead.components.login

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import com.immortalidiot.rutlead.ui.theme.boldInter34

@Composable
fun BoxLabel(
    text: String
) {
    Text(
        text = text,
        modifier = Modifier.fillMaxWidth(),
        color = MaterialTheme.colorScheme.onTertiary,
        textAlign = TextAlign.Center,
        style = boldInter34
    )
}
