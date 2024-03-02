package com.immortalidiot.rutlead.fields

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.immortalidiot.rutlead.R
import com.immortalidiot.rutlead.ui.theme.DarkBlue
import com.immortalidiot.rutlead.ui.theme.InterFontFamily
import com.immortalidiot.rutlead.ui.theme.LightBlue

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PasswordField(type: String) {
    var password by rememberSaveable { mutableStateOf("") }
    var passwordVisible by remember { mutableStateOf(false) }
    var isFocused by remember { mutableStateOf(false) }
    val icon = if(passwordVisible)
        painterResource(id = R.drawable.design_ic_visibility)
    else
        painterResource(id = R.drawable.design_ic_visibility_off)
    TextField(
        modifier = Modifier
            .fillMaxWidth()
            .onFocusChanged { isFocused = !isFocused }
            .border(
                BorderStroke(width = 3.dp, color = Color.Transparent),
                shape = RoundedCornerShape(15.dp)
            ),
        value = password,
        onValueChange = {password = it},
        label = { Text(type,
            style = if (!isFocused) TextStyle(
                fontSize = 10.sp,
                fontFamily = InterFontFamily
            )
            else TextStyle(
                fontSize = 14.sp,
                fontFamily = InterFontFamily
            )
        ) },
        singleLine = true,
        visualTransformation = if (passwordVisible) VisualTransformation.None
        else PasswordVisualTransformation(),
        trailingIcon = {
            IconButton(onClick = {
                passwordVisible = !passwordVisible
            }) {
                Icon(
                    painter = icon,
                    contentDescription = "Visibility Icon")
            }
        },
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Password
        ),
        colors = TextFieldDefaults.textFieldColors(
            containerColor = Color.White,
            textColor = Color.Black,
            cursorColor = LightBlue,
            unfocusedLabelColor = LightBlue,
            focusedLabelColor = DarkBlue,
            unfocusedIndicatorColor = LightBlue,
            focusedIndicatorColor = Color.Transparent,
            focusedTrailingIconColor = LightBlue,
            unfocusedTrailingIconColor = LightBlue
        ),
        shape = RoundedCornerShape(15.dp)
    )
}