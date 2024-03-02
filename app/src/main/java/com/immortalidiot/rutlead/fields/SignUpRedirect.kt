package com.immortalidiot.rutlead.fields

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import com.immortalidiot.rutlead.R
import com.immortalidiot.rutlead.ui.theme.boldInter14

@Composable
fun SignUpRedirect() {
    Text(
        modifier = Modifier
            .padding(start = 3.dp)
            .clickable {  },
        text = stringResource(id = R.string.registration_redirect),
        style = boldInter14,
        color = Color.White,
        textDecoration = TextDecoration.Underline
    )
}