package com.immortalidiot.rutlead.fields

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text.selection.LocalTextSelectionColors
import androidx.compose.foundation.text.selection.TextSelectionColors
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import com.immortalidiot.rutlead.R
import com.immortalidiot.rutlead.ui.theme.LocalDimensions
import com.immortalidiot.rutlead.ui.theme.mediumInter12
import com.immortalidiot.rutlead.ui.theme.mediumInter14

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PasswordField(type: String) {
    val customCursorHandleColor = TextSelectionColors(
        handleColor = MaterialTheme.colorScheme.scrim,
        backgroundColor = MaterialTheme.colorScheme.onBackground
    )
    var password by rememberSaveable { mutableStateOf("") }
    var passwordVisible by remember { mutableStateOf(false) }
    var isFocused by remember { mutableStateOf(false) }
    val isFieldEmpty by remember { derivedStateOf { password.isEmpty() } }
    val icon = if (passwordVisible) painterResource(id = R.drawable.password_visibility_on)
               else painterResource(id = R.drawable.password_visibility_off)

    val dimensions = LocalDimensions.current

    CompositionLocalProvider(LocalTextSelectionColors provides customCursorHandleColor) {
        TextField(
            modifier = Modifier
                .fillMaxWidth()
                .onFocusChanged { isFocused = !isFocused }
                .border(
                    width = dimensions.borderSSmall,
                    color = MaterialTheme.colorScheme.outline,
                    shape = RoundedCornerShape(dimensions.shapeXLarge)
                ),
            value = password,
            onValueChange = { password = it },
            label = {
                Text(
                    text = type,
                    style = if (!isFocused || !isFieldEmpty) mediumInter12
                            else mediumInter14
                )
            },
            visualTransformation = if (passwordVisible) VisualTransformation.None
                                   else PasswordVisualTransformation(),
            trailingIcon = {
                IconButton(
                    onClick =
                    {
                        passwordVisible = !passwordVisible
                    }
                )
                {
                    Icon(
                        painter = icon,
                        contentDescription = "Visibility Icon"
                    )
                }
            },
            singleLine = true,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            colors = TextFieldDefaults.textFieldColors(
                containerColor = MaterialTheme.colorScheme.onPrimaryContainer,
                textColor = MaterialTheme.colorScheme.onSecondary,
                cursorColor = MaterialTheme.colorScheme.onSecondary,
                unfocusedLabelColor = MaterialTheme.colorScheme.onSecondary,
                focusedLabelColor = MaterialTheme.colorScheme.onSecondary,
                unfocusedIndicatorColor = Color.Transparent,
                focusedIndicatorColor = Color.Transparent,
                focusedTrailingIconColor = MaterialTheme.colorScheme.onSecondary,
                unfocusedTrailingIconColor = MaterialTheme.colorScheme.onSecondary
            ),
            shape = RoundedCornerShape(dimensions.shapeXLarge)
        )
    }
}
