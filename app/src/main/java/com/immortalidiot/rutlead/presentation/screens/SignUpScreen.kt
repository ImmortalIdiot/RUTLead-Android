package com.immortalidiot.rutlead.presentation.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import com.immortalidiot.rutlead.R
import com.immortalidiot.rutlead.ui.components.buttons.PrimaryButton
import com.immortalidiot.rutlead.ui.components.fields.ConfirmationPasswordTextField
import com.immortalidiot.rutlead.ui.components.fields.PasswordTextField
import com.immortalidiot.rutlead.ui.components.fields.StudentIDTextField
import com.immortalidiot.rutlead.ui.theme.LocalDimensions
import com.immortalidiot.rutlead.ui.theme.boldInter18
import com.immortalidiot.rutlead.ui.theme.boldInter32
import com.immortalidiot.rutlead.ui.theme.classicWhite
import com.immortalidiot.rutlead.ui.theme.mediumInter18
import com.immortalidiot.rutlead.ui.theme.primaryDarkBlue

@Composable
fun SignUpScreen(
    studentIDPlaceholder: String,
    passwordPlaceholder: String,
    confirmationPasswordPlaceholder: String,
    modifier: Modifier = Modifier,
    signUpButtonPlaceHolder: String,
    toLoginButtonPlaceHolder: String = "",
    errorEmailText: String? = null,
    errorPasswordText: String? = null,
    errorConfirmationPasswordText: String? = null,
    onStudentIDChanged: (String) -> Unit = {},
    onPasswordChanged: (String) -> Unit = {},
    onConfirmationPasswordChanged: (String) -> Unit = {},
    onSignUpButtonClick: () -> Unit = {},
    onToLoginButtonClick: () -> Unit = {}
) {
    val dimensions = LocalDimensions.current

    Column(
        modifier = modifier
            .background(classicWhite)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top,
    ) {
        Spacer(modifier = Modifier.height(dimensions.verticalXXXLLarge))
        Image(
            painter = painterResource(id = R.drawable.auth_icon),
            contentDescription = null
        )
        Spacer(modifier = Modifier.height(dimensions.verticalXLarge))
        Column(
            modifier = modifier
                .background(
                    color = primaryDarkBlue,
                    shape = RoundedCornerShape(dimensions.roundedStandard)
                )
                .fillMaxWidth(0.9f)
                .padding(top = dimensions.verticalSSmall),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,

        ) {
            Text(
                modifier = modifier.padding(top = dimensions.verticalStandard),
                text = stringResource(id = R.string.signup),
                style = boldInter32,
                color = classicWhite
            )
            StudentIDTextField(
                modifier = modifier
                    .fillMaxWidth()
                    .padding(
                        top = dimensions.verticalXLLargePadding,
                        start = dimensions.horizontalStandard,
                        end = dimensions.horizontalStandard
                    ),
                placeholderText = stringResource(id = R.string.student_id_hint),
                errorText = "Длина студенческого билета должна быть 8 символов",
                onTextChange = {
                    onStudentIDChanged(it)
                }
            )
            PasswordTextField(
                modifier = modifier
                    .fillMaxWidth()
                    .padding(
                        top = dimensions.verticalXLLargePadding,
                        start = dimensions.horizontalStandard,
                        end = dimensions.horizontalStandard
                    ),
                placeholderText = stringResource(id = R.string.password_hint),
                errorText = "Длина пароля должна быть от 1 до 16 символов",
                onTextChange = {
                    onPasswordChanged(it)
                }
            )
            ConfirmationPasswordTextField(
                modifier = modifier
                    .fillMaxWidth()
                    .padding(
                        top = dimensions.verticalXLLargePadding,
                        start = dimensions.horizontalStandard,
                        end = dimensions.horizontalStandard
                    ),
                placeholderText = stringResource(id = R.string.confirm_password_hint),
                errorText = "Длина пароля должна быть от 1 до 16 символов",
                onTextChange = {
                    onConfirmationPasswordChanged(it)
                }
            )
            PrimaryButton(
                modifier = modifier
                    .fillMaxWidth(0.6f)
                    .padding(top = dimensions.verticalXLLargePadding),
                text = stringResource(id = R.string.signup),
                onButtonClick = {}
            )
            Row (
                modifier = modifier
                    .fillMaxWidth()
                    .padding(
                        top = dimensions.verticalXLLargePadding,
                        bottom = dimensions.verticalSLarge
                    ),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = stringResource(id = R.string.has_account),
                    style = mediumInter18.copy(color = classicWhite)
                )
                Text(
                    modifier = modifier
                        .padding(start = dimensions.horizontalSSmall)
                        .clickable { onToLoginButtonClick() },
                    text = stringResource(id = R.string.enter),
                    style = boldInter18.copy(color = classicWhite),
                    textDecoration = TextDecoration.Underline
                )
            }
        }
    }
}

@Preview
@Composable
fun SignUpScreenPreview() {
    SignUpScreen(
        studentIDPlaceholder = "Номер студенческого билета",
        passwordPlaceholder = "Пароль",
        confirmationPasswordPlaceholder = "Пароль повторно",
        signUpButtonPlaceHolder = "",
    )
}