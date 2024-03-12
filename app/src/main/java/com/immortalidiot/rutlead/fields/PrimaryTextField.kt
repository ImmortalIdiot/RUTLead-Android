package com.immortalidiot.rutlead.fields

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text.selection.LocalTextSelectionColors
import androidx.compose.foundation.text.selection.TextSelectionColors
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import com.immortalidiot.rutlead.ui.theme.LocalDimensions
import com.immortalidiot.rutlead.ui.theme.mediumInter12
import com.immortalidiot.rutlead.ui.theme.mediumInter14

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PrimaryTextField(
    modifier: Modifier,
    hint: String,
    value: String = "",
    isSingleLine: Boolean = false,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    colors: TextFieldColors,
    maxTextLength: Int? = null,
    onTextChange: (String) -> Unit,
) {
    val dimensions = LocalDimensions.current
    val colorScheme = MaterialTheme.colorScheme

    val isFocused by remember { mutableStateOf(false) }
    val isFieldEmpty by remember { derivedStateOf { value == "" } }

    val customCursorHandleColor = TextSelectionColors(
        handleColor = colorScheme.scrim,
        backgroundColor = colorScheme.onBackground
    )

    CompositionLocalProvider(LocalTextSelectionColors provides customCursorHandleColor) {
        TextField(
            modifier = modifier,
            value = value,
            onValueChange = { text ->
                if (text.length <= (maxTextLength ?: (text.length + 1))) {
                    onTextChange(text)
                }
            },
            label = {
                Text(
                    text = hint,
                    style = if (!isFocused || !isFieldEmpty) mediumInter12
                            else mediumInter14
                )
            },
            singleLine = isSingleLine,
            keyboardOptions = keyboardOptions,
            colors = colors,
            shape = RoundedCornerShape(dimensions.shapeXLarge)
        )
    }
}