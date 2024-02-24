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
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.immortalidiot.rutlead.ui.theme.classicWhite
import com.immortalidiot.rutlead.ui.theme.mediumInter16
import com.immortalidiot.rutlead.ui.theme.primaryDarkBlue
import com.immortalidiot.rutlead.ui.theme.primaryGrayLightTheme
import com.immortalidiot.rutlead.ui.theme.secondaryGrayLightTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun StudentIDTextField(
    modifier: Modifier = Modifier,
    initialStudentIDValue: String = "",
    placeholderText: String?,
    charCount: Int = 8,
    maxLines: Int = 1,
    isError: Boolean = false,
    onTextChange: (studentID: String) -> Unit,
) {

    OutlinedTextField(
        modifier = modifier,
        value = initialStudentIDValue,
        onValueChange = {
            if (it.length <= (charCount)){
                onTextChange(it)
            }
            onTextChange(it)
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
        isError = isError,
        colors = TextFieldDefaults.textFieldColors(
            containerColor = classicWhite,
            focusedIndicatorColor = primaryGrayLightTheme,
            focusedSupportingTextColor = primaryGrayLightTheme,
            unfocusedIndicatorColor = secondaryGrayLightTheme,
            unfocusedSupportingTextColor = secondaryGrayLightTheme,
            placeholderColor = primaryGrayLightTheme,
        ),
        maxLines = maxLines,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
        shape = RoundedCornerShape(size = 12.dp)
    )
}

@Preview()
@Composable
fun StudentIDTextFieldPreview() {
    StudentIDTextField(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        placeholderText = "Номер студенческого билета",
        onTextChange = {},
        isError = false
    )
}