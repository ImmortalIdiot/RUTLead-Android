package com.immortalidiot.rutlead.buttons.login

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.immortalidiot.rutlead.ui.theme.LocalDimensions
import com.immortalidiot.rutlead.ui.theme.boldLato20

@Composable
fun SignInButton(
    modifier: Modifier,
    text: String,
    onButtonClick: () -> Unit,
) {
    val dimensions = LocalDimensions.current
    val colorScheme = MaterialTheme.colorScheme
    val roundedShape = RoundedCornerShape(dimensions.shapeSLarge)

    Button(
        onClick = {
            onButtonClick()
        },
        modifier = modifier
            .fillMaxHeight(0.3f)
            .fillMaxWidth(0.55f)
            .border(
                width = dimensions.borderSSmall,
                shape = roundedShape,
                color = colorScheme.onSecondaryContainer
            ),
        shape = roundedShape,
        colors = ButtonDefaults.buttonColors(containerColor = colorScheme.primary)
    ) {
        Box(contentAlignment = Alignment.Center) {
            Text(
                text = text,
                style = boldLato20,
                color = colorScheme.onTertiary
            )
        }
    }
}
