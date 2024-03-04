package com.immortalidiot.rutlead.fields

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text.selection.LocalTextSelectionColors
import androidx.compose.foundation.text.selection.TextSelectionColors
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.immortalidiot.rutlead.ui.theme.DarkBlue
import com.immortalidiot.rutlead.ui.theme.DarkWhite
import com.immortalidiot.rutlead.ui.theme.InterFontFamily
import com.immortalidiot.rutlead.ui.theme.LightBlue
import com.immortalidiot.rutlead.ui.theme.LocalDimensions
import com.immortalidiot.rutlead.ui.theme.boldInter14
import com.immortalidiot.rutlead.ui.theme.primaryDarkBlue

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun StudentIdTextField(type: String) {
    val customCursorHandleColor = TextSelectionColors(
        handleColor = MaterialTheme.colorScheme.scrim,
        backgroundColor = MaterialTheme.colorScheme.onBackground
    )
    var text by remember { mutableStateOf("") }
    var isFocused by remember { mutableStateOf(false) }
    val textLength = 6
    val isFieldEmpty by remember {
        derivedStateOf { text.isEmpty() }
    }
    val dimensions = LocalDimensions.current
    CompositionLocalProvider(LocalTextSelectionColors provides customCursorHandleColor) {
        TextField(
            modifier = Modifier
                .fillMaxWidth()
                .onFocusChanged { isFocused = !isFocused }
                .border(
                    width = dimensions.borderXSWidth,
                    color = MaterialTheme.colorScheme.outline,
                    shape = RoundedCornerShape(dimensions.shapeXXLRound)
                ),
            value = text,
            onValueChange = {
                if (it.length <= textLength) text = it
            },
            label = {
                Text(
                    type,
                    style = if (!isFocused || !isFieldEmpty) TextStyle(
                        fontSize = 12.sp,
                        fontFamily = InterFontFamily
                    )
                    else TextStyle(
                        fontSize = 14.sp,
                        fontFamily = InterFontFamily
                    )
                )
            },
            singleLine = true,
            colors = TextFieldDefaults.textFieldColors(
                containerColor = MaterialTheme.colorScheme.onPrimaryContainer,
                textColor = MaterialTheme.colorScheme.onSecondary,
                cursorColor = MaterialTheme.colorScheme.onSecondary,
                unfocusedLabelColor = MaterialTheme.colorScheme.onSecondary,
                focusedLabelColor = MaterialTheme.colorScheme.onSecondary,
                focusedSupportingTextColor = Color.White,
                unfocusedIndicatorColor = Color.Transparent,
                focusedIndicatorColor = Color.Transparent
            ),

            shape = RoundedCornerShape(15.dp),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
    }
}