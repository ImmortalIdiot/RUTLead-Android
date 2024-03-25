package com.immortalidiot.rutlead.ui.components.fields

import androidx.compose.foundation.border
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text.selection.LocalTextSelectionColors
import androidx.compose.foundation.text.selection.TextSelectionColors
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
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
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.immortalidiot.rutlead.R
import com.immortalidiot.rutlead.ui.theme.ThemeColors
import com.immortalidiot.rutlead.ui.theme.mediumInter12
import com.immortalidiot.rutlead.ui.theme.mediumInter14

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PasswordField(
    hint: String,
    palette: ThemeColors,
    modifier: Modifier = Modifier,
    passwordValue: String = "",
    imageVector: ImageVector,
    visualTransformation: VisualTransformation,
    onDoneAction: () -> Unit,
    onIconClick: () -> Unit,
    onTextChange: (password: String) -> Unit
) {
    val customCursorHandleColor = TextSelectionColors(
        handleColor = palette.handle,
        backgroundColor = palette.handleBackground
    )

    var isFocused by remember { mutableStateOf(false) }

    val transparentColor = Color.Transparent

    CompositionLocalProvider(LocalTextSelectionColors provides customCursorHandleColor) {
        PrimaryTextField(
            modifier = modifier
                .fillMaxWidth()
                .onFocusChanged { isFocused = !isFocused },
            value = passwordValue,
            onTextChange = {
                onTextChange(it)
            },
            label = {
                Text(
                    text = hint,
                    style = if (!isFocused || passwordValue.isNotBlank()) {
                        mediumInter12.copy(color = palette.containerText)
                    } else {
                        mediumInter14.copy(color = palette.containerText)
                    }
                )
            },
            visualTransformation = visualTransformation,
            trailingIcon = {
                IconButton(
                    onClick = onIconClick,
                    colors = IconButtonDefaults.iconButtonColors(
                        contentColor = palette.content
                    )
                ) {
                    Icon(
                        imageVector = imageVector,
                        contentDescription = "Visibility Icon"
                    )
                }
            },
            isSingleLine = true,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            keyboardActions = KeyboardActions(onDone = { onDoneAction() }),
            colors = TextFieldDefaults.textFieldColors(
                containerColor = palette.container,
                textColor = palette.containerText,
                cursorColor = palette.cursor,
                unfocusedLabelColor = palette.labelText,
                focusedLabelColor = palette.labelText,
                unfocusedIndicatorColor = transparentColor,
                focusedIndicatorColor = transparentColor,
                focusedTrailingIconColor = palette.content,
                unfocusedTrailingIconColor = palette.content
            ),
        )
    }
}

@Preview
@Composable
fun PasswordFieldPreview() {
    PasswordField(
        hint = "Пароль",
        palette = if (isSystemInDarkTheme()) ThemeColors.Dark else ThemeColors.Light,
        modifier = Modifier
            .padding(
                top = 100.dp,
                start = 10.dp,
                end = 10.dp
            )
            .border(
                width = 5.dp,
                color = ThemeColors.Light.content,
                shape = RoundedCornerShape(size = 20.dp)
            ),
        imageVector = ImageVector.vectorResource(id = R.drawable.password_visibility_on),
        visualTransformation = VisualTransformation.None,
        onIconClick = {},
        onDoneAction = {},
        onTextChange = {}
    )
}
