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
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
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
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import com.immortalidiot.rutlead.R
import com.immortalidiot.rutlead.buttons.login.PrimaryButton
import com.immortalidiot.rutlead.components.login.AccountMissing
import com.immortalidiot.rutlead.components.login.BottomSnackbar
import com.immortalidiot.rutlead.components.login.BoxLabel
import com.immortalidiot.rutlead.components.login.RedirectText
import com.immortalidiot.rutlead.fields.PasswordField
import com.immortalidiot.rutlead.fields.StudentIdTextField
import com.immortalidiot.rutlead.providers.LocalSnackbarHostState
import com.immortalidiot.rutlead.providers.showMessage
import com.immortalidiot.rutlead.ui.theme.LocalDimensions
import com.immortalidiot.rutlead.ui.theme.ThemeColors
import com.immortalidiot.rutlead.viewmodels.LoginScreenViewModel

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun LoginDesign(
    modifier: Modifier = Modifier,
    viewModel: LoginScreenViewModel,
    palette: ThemeColors,
) {
    val dimensions = LocalDimensions.current
    val roundedShape = RoundedCornerShape(dimensions.shapeXLarge)

    val uiState by viewModel.uiState.collectAsState()
    val state by viewModel.mutableState.collectAsState()

    val snackbarHostState = LocalSnackbarHostState.current
    val keyboardController = LocalSoftwareKeyboardController.current
    val focusManager = LocalFocusManager.current

    var studentIDErrorMessage = ""
    var passwordErrorMessage = ""

    (state as? LoginScreenViewModel.State.ValidationError)?.let { errorState ->
        studentIDErrorMessage = errorState.studentIDError.toString()
        passwordErrorMessage = errorState.passwordError.toString()
    }

    LaunchedEffect(key1 = state) {
        if (state is LoginScreenViewModel.State.ValidationError) {
            val errorState = state as LoginScreenViewModel.State.ValidationError

            when {
                errorState.studentIDError != null ->
                    snackbarHostState.showMessage(studentIDErrorMessage)

                errorState.passwordError != null ->
                    snackbarHostState.showMessage(passwordErrorMessage)
            }
            viewModel.clearErrorStack()
        }
    }
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
                .clip(roundedShape)
                .background(color = palette.primary)
                .border(
                    width = dimensions.borderSSmall,
                    color = palette.outline,
                    shape = roundedShape
                )
                .padding(vertical = dimensions.verticalBigPadding)
        ) {
            Column(
                modifier = modifier.fillMaxWidth(0.85f),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                BoxLabel(
                    text = "Авторизация",
                    palette = palette
                )
                Spacer(modifier = modifier.height(dimensions.verticalXXLarge))
                StudentIdTextField(
                    hint = "Номер студенческого билета",
                    palette = palette,
                    value = uiState.studentID,
                    onTextChange = { studentID -> viewModel.changeLogin(studentID) }
                )
                Spacer(modifier = modifier.height(dimensions.verticalXLarge))
                PasswordField(
                    hint = "Пароль",
                    palette = palette,
                    modifier = modifier.border(
                        width = dimensions.borderSSmall,
                        color = palette.outline,
                        shape = roundedShape
                    ),
                    passwordValue = uiState.password,
                    imageVector = if (uiState.isPasswordVisible) {
                        ImageVector.vectorResource(id = R.drawable.password_visibility_on)
                    } else {
                        ImageVector.vectorResource(id = R.drawable.password_visibility_off)
                    },
                    visualTransformation = if (uiState.isPasswordVisible) {
                        VisualTransformation.None
                    } else {
                        PasswordVisualTransformation()
                    },
                    onDoneAction = {
                        focusManager.clearFocus()
                        keyboardController?.hide()
                        viewModel.request()
                    },
                    onIconClick = {
                        viewModel.changePasswordVisibility(uiState.isPasswordVisible)
                    },
                    onTextChange = { password -> viewModel.changePassword(password) },
                )
                Spacer(modifier = Modifier.height(dimensions.verticalXLarge))
                PrimaryButton(
                    modifier = modifier
                        .fillMaxHeight(0.14f)
                        .fillMaxWidth(0.55f),
                    palette = palette,
                    text = "Войти",
                    onButtonClick = {
                        focusManager.clearFocus()
                        keyboardController?.hide()
                        viewModel.request()
                    }
                )
                Spacer(modifier = modifier.height(dimensions.verticalXLarge))
                Row(
                    modifier = modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center
                ) {
                    AccountMissing(palette = palette)
                    RedirectText(
                        modifier = modifier,
                        text = "Зарегистрируйтесь",
                        palette = palette,
                        onTextClick = {
                            // TODO: move user to sign up screen
                        }
                    )
                }
                Spacer(modifier = modifier.height(dimensions.verticalXSmall))
                RedirectText(
                    modifier = modifier,
                    text = "Забыли пароль?",
                    palette = palette,
                    onTextClick = {
                        // TODO: show the password changing window to the user
                    }
                )
                Spacer(modifier = modifier.height(dimensions.verticalSLarge))
            }
        }
    }
    BottomSnackbar(
        modifier = modifier,
        palette = palette,
        snackbarHostState = snackbarHostState
    )
}

@Preview
@Composable
fun LoginScreenPreview() {
    LoginDesign(
        viewModel = LoginScreenViewModel(),
        palette = if (isSystemInDarkTheme()) ThemeColors.Dark else ThemeColors.Light
    )
}
