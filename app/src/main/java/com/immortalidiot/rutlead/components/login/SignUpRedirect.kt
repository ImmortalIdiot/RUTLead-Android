package com.immortalidiot.rutlead.components.login

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextDecoration
import com.immortalidiot.rutlead.ui.theme.LocalDimensions
import com.immortalidiot.rutlead.ui.theme.ThemeColors
import com.immortalidiot.rutlead.ui.theme.boldInter14

@Composable
fun RedirectText(
    modifier: Modifier,
    text: String,
    palette: ThemeColors,
    onTextClick: () -> Unit
) {
    Text(
        modifier = modifier
            .padding(start = LocalDimensions.current.verticalSmallPadding)
            .clickable {
                onTextClick()
            },
        text = text,
        style = boldInter14,
        color = palette.text,
        textDecoration = TextDecoration.Underline
    )
}
