package com.immortalidiot.rutlead.fields

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text.selection.LocalTextSelectionColors
import androidx.compose.foundation.text.selection.TextSelectionColors
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import com.immortalidiot.rutlead.ui.theme.LocalDimensions
import com.immortalidiot.rutlead.ui.theme.ThemeColors
import com.immortalidiot.rutlead.ui.theme.mediumInter12
import com.immortalidiot.rutlead.ui.theme.mediumInter14

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun StudentEmailTextField(
    hint: String,
    palette: ThemeColors,
    modifier: Modifier = Modifier,
    value: String = "",
    onTextChange: (studentID: String) -> Unit
) {

    val dimensions = LocalDimensions.current
    val roundedShape = RoundedCornerShape(dimensions.shapeXLarge)

    val customCursorHandleColor = TextSelectionColors(
        handleColor = palette.handle,
        backgroundColor = palette.handleBackground
    )

    var isFocused by remember { mutableStateOf(false) }

    CompositionLocalProvider(LocalTextSelectionColors provides customCursorHandleColor) {
        PrimaryTextField(
            modifier = modifier
                .fillMaxWidth()
                .onFocusChanged {
                    isFocused = !isFocused
                }
                .border(
                    width = dimensions.borderSSmall,
                    color = palette.outline,
                    shape = roundedShape
                ),
            value = value,
            maxTextLength = 8,
            onTextChange = {
                onTextChange(it)
            },
            label = {
                Text(
                    text = hint,
                    style = if (!isFocused || value.isNotBlank()) {
                        mediumInter12.copy(color = palette.containerText)
                    } else {
                        mediumInter14.copy(color = palette.containerText)
                    }
                )
            },
            isSingleLine = true,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
            colors = TextFieldDefaults.textFieldColors(
                containerColor = palette.container,
                textColor = palette.containerText,
                cursorColor = palette.cursor,
                unfocusedLabelColor = palette.label,
                focusedLabelColor = palette.label,
                focusedSupportingTextColor = Color.White,
                unfocusedIndicatorColor = Color.Transparent,
                focusedIndicatorColor = Color.Transparent
            ),
        )
    }
}
