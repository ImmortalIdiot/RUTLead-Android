package com.immortalidiot.rutlead.ui.components.buttons

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.immortalidiot.rutlead.ui.theme.LocalDimensions
import com.immortalidiot.rutlead.ui.theme.classicBlack
import com.immortalidiot.rutlead.ui.theme.classicWhite
import com.immortalidiot.rutlead.ui.theme.mediumInter16
import com.immortalidiot.rutlead.ui.theme.primaryDarkBlue
import com.immortalidiot.rutlead.ui.theme.primaryGrayLightTheme

@Composable
fun PrimaryButton(
    text: String?,
    onButtonClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    val dimensions = LocalDimensions.current

    Button(
        modifier = modifier,
        shape = RoundedCornerShape(dimensions.verticalSSmall),

        onClick = {
            onButtonClick()
        },
        colors = ButtonDefaults.buttonColors(
            containerColor = classicWhite,
            contentColor = classicBlack,
            disabledContainerColor = classicWhite,
            disabledContentColor = primaryGrayLightTheme
        ),

    ) {
        Text(
            text = text ?: "",
            style = mediumInter16.copy(color = primaryDarkBlue)
        )
    }
}

@Preview
@Composable
fun PrimaryButtonPreview() {
    PrimaryButton(
        text = "Something",
        onButtonClick = {}
    )
}