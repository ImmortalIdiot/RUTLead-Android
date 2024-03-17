package com.immortalidiot.rutlead.buttons.registration

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.immortalidiot.rutlead.ui.theme.LocalDimensions
import com.immortalidiot.rutlead.ui.theme.ThemeColors
import com.immortalidiot.rutlead.ui.theme.boldLato20

@Composable
fun SignUpNextButton(
    modifier: Modifier,
    palette: ThemeColors,
    text: String,
    onButtonClick: () -> Unit,
) {
    val dimensions = LocalDimensions.current
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
                color = palette.outline
            ),
        shape = roundedShape,
        colors = ButtonDefaults.buttonColors(containerColor = palette.container)
    ) {
        Box(contentAlignment = Alignment.Center) {
            Text(
                text = text,
                style = boldLato20,
                color = palette.containerText
            )
        }
    }
}
