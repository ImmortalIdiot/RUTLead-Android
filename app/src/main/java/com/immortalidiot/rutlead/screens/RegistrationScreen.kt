package com.immortalidiot.rutlead.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import com.immortalidiot.rutlead.R
import com.immortalidiot.rutlead.buttons.registration.SignUpNextButton
import com.immortalidiot.rutlead.buttons.registration.SignUpRegButton
import com.immortalidiot.rutlead.components.login.AccountIsPresent
import com.immortalidiot.rutlead.components.login.BoxLabel
import com.immortalidiot.rutlead.components.login.SignInRedirectText
import com.immortalidiot.rutlead.fields.PasswordField
import com.immortalidiot.rutlead.fields.StudentEmailTextField
import com.immortalidiot.rutlead.fields.StudentGroupTextField
import com.immortalidiot.rutlead.fields.StudentIdTextField
import com.immortalidiot.rutlead.fields.StudentNameTextField
import com.immortalidiot.rutlead.ui.theme.LocalDimensions
import com.immortalidiot.rutlead.ui.theme.ThemeColors
import com.immortalidiot.rutlead.viewmodels.RegistrationScreenViewModel

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun RegistrationDesign(
    modifier: Modifier = Modifier,
    viewModel: RegistrationScreenViewModel,
    palette: ThemeColors,
) {
    val dimensions = LocalDimensions.current
    val roundedShape = RoundedCornerShape(dimensions.shapeXLarge)

    val uiState by viewModel.uiRegState.collectAsState()
    val state by viewModel.mutableState.collectAsState()

   // val snackbarHostState = LocalSnackbarHostState.current
    val keyboardController = LocalSoftwareKeyboardController.current
    val focusManager = LocalFocusManager.current
    var nextScreen = true

    if (nextScreen) { //TODO: chane screens
        Column(
            modifier = modifier
                .fillMaxSize()
                .background(color = palette.surface),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                modifier = modifier
                    .fillMaxWidth(0.4f)
                    .fillMaxHeight(0.07f),
                imageVector = ImageVector.vectorResource(
                    id = if (isSystemInDarkTheme()) {
                        R.drawable.ic_app_dark_logo
                    } else {
                        R.drawable.ic_app_light_logo
                    }
                ),
                contentDescription = "logo",
            )
            Spacer(modifier = modifier.height(dimensions.verticalXXLarge))
            Box(
                contentAlignment = Alignment.Center,
                modifier = modifier
                    .fillMaxWidth(0.85f)
                    .fillMaxHeight(0.65f)
                    .clip(roundedShape)
                    .background(color = palette.primary)
                    .border(
                        width = dimensions.borderSSmall,
                        color = palette.outline,
                        shape = roundedShape
                    )
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = modifier
                        .fillMaxWidth(0.85f)

                ) {
                    BoxLabel(
                        text = "Регистрация",
                        palette = palette
                    )
                    Spacer(modifier = modifier.height(dimensions.verticalXXLarge))
                    StudentIdTextField(
                        hint = "Номер студенческого билета",
                        palette = palette,
                        value = uiState.studentID,
                        onTextChange = { studentID ->
                            viewModel.changeId(studentID)
                        }
                    )
                    Spacer(modifier = modifier.height(dimensions.verticalXLarge))
                    StudentEmailTextField(
                        hint = "Электронная почта",
                        palette = palette,
                        value = uiState.studentEmail,
                        onTextChange = { studentEmail ->
                            viewModel.changeEmail(studentEmail)
                        }
                    )
                    Spacer(modifier = modifier.height(dimensions.verticalXLarge))
                    PasswordField(
                        hint = "Пароль",
                        palette = palette,
                        modifier = modifier
                            .border(
                                width = dimensions.borderSSmall,
                                color = palette.outline,
                                shape = roundedShape
                            ),
                        onDoneAction = {
                            focusManager.clearFocus()
                            keyboardController?.hide()
                            viewModel.request()
                        },
                        passwordValue = uiState.password,
                        onTextChange = { password ->
                            viewModel.changePassword(password)
                        },
                    )
                    Spacer(modifier = Modifier.height(dimensions.verticalXLarge))
                    SignUpNextButton(
                        modifier = modifier,
                        palette = palette,
                        text = "Далее",
                        onButtonClick = {
                            focusManager.clearFocus()
                            keyboardController?.hide()
                            viewModel.request()
                            nextScreen = false

                        },
                    )
                    Spacer(modifier = modifier.height(dimensions.verticalSLarge))
                    Row(
                        modifier = modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center
                    ) {
                        AccountIsPresent(
                            palette = palette
                        )
                        SignInRedirectText(
                            modifier = modifier,
                            text = "Войдите",
                            palette = palette,
                            onTextClick = {
                                // TODO: move user to sign in screen
                            }
                        )
                    }
                    Spacer(modifier = modifier.height(dimensions.verticalSLarge))
                }
            }
        }
//    BottomSnackbar(
//        modifier = modifier,
//        palette = palette,
//        snackbarHostState = snackbarHostState
//    )
    } else{
        Column(
            modifier = modifier
                .fillMaxSize()
                .background(color = palette.surface),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                modifier = modifier
                    .fillMaxWidth(0.4f)
                    .fillMaxHeight(0.07f),
                imageVector = ImageVector.vectorResource(
                    id = if (isSystemInDarkTheme()) {
                        R.drawable.ic_app_dark_logo
                    } else {
                        R.drawable.ic_app_light_logo
                    }
                ),
                contentDescription = "logo",
            )
            Spacer(modifier = modifier.height(dimensions.verticalXXLarge))
            Box(
                contentAlignment = Alignment.Center,
                modifier = modifier
                    .fillMaxWidth(0.85f)
                    .fillMaxHeight(0.55f)
                    .clip(roundedShape)
                    .background(color = palette.primary)
                    .border(
                        width = dimensions.borderSSmall,
                        color = palette.outline,
                        shape = roundedShape
                    )
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = modifier
                        .fillMaxWidth(0.85f)

                ) {
                    BoxLabel(
                        text = "Регистрация",
                        palette = palette
                    )
                    Spacer(modifier = modifier.height(dimensions.verticalXXLarge))
                    StudentNameTextField(
                        hint = "ФИО",
                        palette = palette,
                        value = uiState.studentName,
                        onTextChange = { studentName ->
                            viewModel.changeName(studentName)
                        }
                    )
                    Spacer(modifier = modifier.height(dimensions.verticalXLarge))
                    StudentGroupTextField(
                        hint = "Группа (АБВ-123)",
                        palette = palette,
                        value = uiState.studentEmail,
                        onTextChange = { studentEmail ->
                            viewModel.changeEmail(studentEmail)
                        }
                    )
                    Spacer(modifier = Modifier.height(dimensions.verticalXLarge))
                    SignUpRegButton(
                        modifier = modifier,
                        palette = palette,
                        text = "Войти",
                        onButtonClick = {
                            focusManager.clearFocus()
                            keyboardController?.hide()
                            viewModel.request()
                                        //TODO: move user to main part of the app
                        },
                    )
                    Spacer(modifier = modifier.height(dimensions.verticalSLarge))
                    Row(
                        modifier = modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center
                    ) {
                        AccountIsPresent(
                            palette = palette
                        )
                        SignInRedirectText(
                            modifier = modifier,
                            text = "Войдите",
                            palette = palette,
                            onTextClick = {
                                // TODO: move user to sign in screen
                            }
                        )
                    }
                    Spacer(modifier = modifier.height(dimensions.verticalNormal))
                }
            }
            Spacer(modifier = modifier.height(dimensions.verticalXLarge))
            Spacer(modifier = modifier.height(dimensions.verticalXLarge))
            Spacer(modifier = modifier.height(dimensions.verticalNormal))
        }
    }
}

@Preview
@Composable
fun RegistrationScreenPreview() {
    RegistrationDesign(
        viewModel = RegistrationScreenViewModel(),
        palette = if (isSystemInDarkTheme()) ThemeColors.Dark
        else ThemeColors.Light
    )
}
