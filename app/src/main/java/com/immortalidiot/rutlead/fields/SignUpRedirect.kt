package com.immortalidiot.rutlead.fields

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextDecoration
import com.immortalidiot.rutlead.R
import com.immortalidiot.rutlead.ui.theme.LocalDimensions
import com.immortalidiot.rutlead.ui.theme.boldInter14

@Composable
fun SignUpRedirect() {
    Text(
        modifier = Modifier
            .padding(start = LocalDimensions.current.verticalSmallPadding)
            .clickable { /*TODO*/ },
        text = stringResource(id = R.string.registration_redirect),
        style = boldInter14,
        color = MaterialTheme.colorScheme.onTertiary,
        textDecoration = TextDecoration.Underline
    )
}