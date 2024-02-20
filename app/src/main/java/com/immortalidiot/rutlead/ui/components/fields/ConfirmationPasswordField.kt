package com.immortalidiot.rutlead.ui.components.fields

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.immortalidiot.rutlead.R
import com.immortalidiot.rutlead.ui.theme.classicWhite
import com.immortalidiot.rutlead.ui.theme.mediumInter16
import com.immortalidiot.rutlead.ui.theme.primaryDarkBlue
import com.immortalidiot.rutlead.ui.theme.secondaryGrayLightTheme
import com.immortalidiot.rutlead.ui.theme.primaryGrayLightTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ConfirmationPasswordTextField(
    modifier: Modifier = Modifier,
    initialPasswordValue: String = "",
    placeholderText: String?,
    minCharCount: Int? = 0,
    maxCharCount: Int? = 16,
    maxLines: Int = 1,
    isEnabled: Boolean = true,
    isError: Boolean = false,
    onTextChange: (password: String) -> Unit,
) {
    var passwordValue by rememberSaveable {
        mutableStateOf(initialPasswordValue)
    }
    var isPasswordVisible by rememberSaveable {
        mutableStateOf(false)
    }

    OutlinedTextField(
        modifier = modifier,
        value = passwordValue,
        onValueChange = {
            if (it.length <= (maxCharCount ?: (it.length + 1)) ||
                (it.length >= (minCharCount ?: (it.length - 1)))) {
                passwordValue = it
                onTextChange(it)
            }
        },
        visualTransformation = if (isPasswordVisible) {
            VisualTransformation.None
        } else {
            PasswordVisualTransformation()
        },
        textStyle = mediumInter16.copy(color = primaryDarkBlue),
        placeholder = {
            placeholderText?.let {
                Text(
                    text = it,
                    style = mediumInter16.copy(color = primaryGrayLightTheme)
                )
            }
        },
        enabled = isEnabled,
        isError = isError,
        colors = TextFieldDefaults.textFieldColors(
            containerColor = classicWhite,
            focusedIndicatorColor = primaryGrayLightTheme,
            focusedSupportingTextColor = primaryGrayLightTheme,
            unfocusedIndicatorColor = secondaryGrayLightTheme,
            unfocusedSupportingTextColor = secondaryGrayLightTheme,
            placeholderColor = primaryGrayLightTheme,
        ),
        trailingIcon = {
            if (isPasswordVisible) {
                IconButton(
                    onClick = {
                        isPasswordVisible = !isPasswordVisible
                    }
                ) {
                    Icon(
                        painterResource(id = R.drawable.password_vision_on),
                        contentDescription = null,
                        tint = primaryDarkBlue
                    )
                }
            } else {
                IconButton(
                    onClick = {
                        isPasswordVisible = !isPasswordVisible
                    }
                ) {
                    Icon(
                        painterResource(id = R.drawable.password_vision_off),
                        contentDescription = null,
                        tint = primaryDarkBlue
                    )
                }
            }
        },
        maxLines = maxLines,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        shape = RoundedCornerShape(size = 12.dp)
    )
}

@Preview
@Composable
fun ConfirmationPasswordTextFieldPreview() {
    ConfirmationPasswordTextField(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        placeholderText = "Пароль повторно",
        onTextChange = {},
        isEnabled = true,
        isError = false
    )
}