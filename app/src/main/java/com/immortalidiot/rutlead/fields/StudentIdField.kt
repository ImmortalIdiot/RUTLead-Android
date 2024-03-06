package com.immortalidiot.rutlead.fields

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text.selection.LocalTextSelectionColors
import androidx.compose.foundation.text.selection.TextSelectionColors
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.immortalidiot.rutlead.ui.theme.InterFontFamily
import com.immortalidiot.rutlead.ui.theme.LocalDimensions
import com.immortalidiot.rutlead.ui.theme.boldInter12
import com.immortalidiot.rutlead.ui.theme.boldInter14
import com.immortalidiot.rutlead.ui.theme.mediumInter12
import com.immortalidiot.rutlead.ui.theme.mediumInter14

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun StudentIdTextField(type: String) {
    val customCursorHandleColor = TextSelectionColors(
        handleColor = MaterialTheme.colorScheme.scrim,
        backgroundColor = MaterialTheme.colorScheme.onBackground
    )
    var text by remember { mutableStateOf("") }
    var isFocused by remember { mutableStateOf(false) }
    val textLength = 8
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
                    style = if (!isFocused || !isFieldEmpty) {
                        mediumInter12
                    } else {
                        mediumInter14
                    }
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
