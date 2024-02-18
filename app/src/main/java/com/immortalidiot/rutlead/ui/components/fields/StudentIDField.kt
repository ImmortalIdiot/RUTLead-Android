package com.immortalidiot.rutlead.ui.components.fields

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.immortalidiot.rutlead.ui.theme.boldInter16
import com.immortalidiot.rutlead.ui.theme.boldLato12
import com.immortalidiot.rutlead.ui.theme.classicWhite
import com.immortalidiot.rutlead.ui.theme.mediumInter16
import com.immortalidiot.rutlead.ui.theme.primaryDarkBlue
import com.immortalidiot.rutlead.ui.theme.secondaryGrayLightTheme
import com.immortalidiot.rutlead.ui.theme.primaryGrayLightTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun StudentIDTextField(
    modifier: Modifier = Modifier,
    initialStudentIDValue: String = "",
    placeholderText: String?,
    errorText: String?,
    charCount: Int = 8,
    maxLines: Int = 1,
    isError: Boolean = false,
    onTextChange: (studentID: String) -> Unit,
) {
    var studentIDValue by rememberSaveable {
        mutableStateOf(initialStudentIDValue)
    }

    OutlinedTextField(
        modifier = modifier,
        value = studentIDValue,
        onValueChange = {
            if (it.length <= (charCount)){
                studentIDValue = it
                onTextChange(it)
            }
        },
        textStyle = boldInter16.copy(color = classicWhite),
        placeholder = {
            placeholderText?.let {
                Text(
                    text = it,
                    style = mediumInter16.copy(color = primaryGrayLightTheme)
                )
            }
        },
        isError = isError,
        colors = TextFieldDefaults.textFieldColors(
            textColor = primaryDarkBlue,
            containerColor = classicWhite,
            focusedIndicatorColor = primaryGrayLightTheme,
            focusedSupportingTextColor = primaryGrayLightTheme,
            unfocusedIndicatorColor = secondaryGrayLightTheme,
            unfocusedSupportingTextColor = secondaryGrayLightTheme,
            placeholderColor = classicWhite,
        ),
        supportingText = {
            errorText?.let {
                if (isError) {
                    Text(
                        modifier = modifier,
                        text = it,
                        style = boldLato12.copy(color = secondaryGrayLightTheme)
                    )
                }
            }
        },
        maxLines = maxLines,
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Number
        ),
        shape = RoundedCornerShape(size = 12.dp)
    )
}

@Preview
@Composable
fun StudentIDTextFieldPreview() {
    StudentIDTextField(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        placeholderText = "Номер студенческого билета",
        errorText = "Длина номера должна быть 8 цифр",
        onTextChange = {},
        isError = false
    )
}