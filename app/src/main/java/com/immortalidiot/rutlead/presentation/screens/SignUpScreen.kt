package com.immortalidiot.rutlead.presentation.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Snackbar
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import com.immortalidiot.rutlead.R
import com.immortalidiot.rutlead.presentation.viewmodels.SignUpViewModel
import com.immortalidiot.rutlead.ui.components.buttons.PrimaryButton
import com.immortalidiot.rutlead.ui.components.fields.ConfirmationPasswordTextField
import com.immortalidiot.rutlead.ui.components.fields.PasswordTextField
import com.immortalidiot.rutlead.ui.components.fields.StudentIDTextField
import com.immortalidiot.rutlead.ui.providers.showMessage
import com.immortalidiot.rutlead.ui.theme.LocalDimensions
import com.immortalidiot.rutlead.ui.theme.boldInter18
import com.immortalidiot.rutlead.ui.theme.boldInter32
import com.immortalidiot.rutlead.ui.theme.classicWhite
import com.immortalidiot.rutlead.ui.theme.mediumInter18
import com.immortalidiot.rutlead.ui.theme.mediumInter24
import com.immortalidiot.rutlead.ui.theme.primaryDarkBlue
import kotlinx.coroutines.launch

@Composable
fun SignUpScreen(
    modifier: Modifier = Modifier,
    onToLoginButtonClick: () -> Unit = {},
    viewModel: SignUpViewModel
) {
    val state by viewModel.mutableState.collectAsState()
    val uiState by viewModel.uiState.collectAsState()
    val snackbarHostState = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()

    LaunchedEffect(key1 = state) {
        when {
            (state is SignUpViewModel.State.ValidationError) &&
                    (state as? SignUpViewModel.State.ValidationError)?.
                    studentIDError != null -> {
                snackbarHostState.showMessage(
                    (state as? SignUpViewModel.State.ValidationError)?.
                    studentIDError.toString()
                )
            }

            (state is SignUpViewModel.State.ValidationError) &&
                    (state as? SignUpViewModel.State.ValidationError)?.
                    passwordError != null -> {
                snackbarHostState.showMessage(
                    (state as? SignUpViewModel.State.ValidationError)?.
                    passwordError.toString()
                )
            }

            (state is SignUpViewModel.State.ValidationError) &&
                    (state as? SignUpViewModel.State.ValidationError)?.
                    confirmationPasswordError != null -> {
                snackbarHostState.showMessage(
                    (state as? SignUpViewModel.State.ValidationError)?.
                    confirmationPasswordError.toString()
                )
            }

            (state is SignUpViewModel.State.Success) ->
                snackbarHostState.showMessage("Успешный вход")
        }
    }

    val dimensions = LocalDimensions.current
    Column(
        modifier = modifier
            .background(classicWhite)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top,
    ) {
        Spacer(modifier = Modifier.height(dimensions.verticalXXLLarge))
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
                initialStudentIDValue = uiState.studentID,
                placeholderText = stringResource(id = R.string.student_id_hint),
                isError = (state is SignUpViewModel.State.Error) ||
                        (state as? SignUpViewModel.State.ValidationError)?.studentIDError != null,
                onTextChange = { studentID ->
                    viewModel.changeStudentID(studentID)
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
                initialPasswordValue = uiState.password,
                placeholderText = stringResource(id = R.string.password_hint),
                isError = (state is SignUpViewModel.State.Error) ||
                        (state as? SignUpViewModel.State.ValidationError)?.passwordError != null,


                onTextChange = { password ->
                    viewModel.changePassword(password)
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
                isError = (state is SignUpViewModel.State.Error) ||
                        (state as? SignUpViewModel.State.ValidationError)?.confirmationPasswordError != null,
                onTextChange = { confirmationPassword ->
                    viewModel.changeConfirmationPassword(confirmationPassword)
                }
            )
            PrimaryButton(
                modifier = modifier
                    .fillMaxWidth(0.6f)
                    .padding(top = dimensions.verticalXLLargePadding),
                text = stringResource(id = R.string.signup),
                buttonStyle = mediumInter24.copy(color = primaryDarkBlue),
                onButtonClick = {
                    scope.launch {
                        viewModel.request()
                    }
                }
            )

            Row(
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
                        .clickable {
                            onToLoginButtonClick(
                                // TODO: switch to Login screen
                            )
                        },
                    text = stringResource(id = R.string.enter),
                    style = boldInter18.copy(color = classicWhite),
                    textDecoration = TextDecoration.Underline
                )
            }
        }

        Box {
            SnackbarHost(
                hostState = snackbarHostState,
                modifier = modifier.align(Alignment.BottomCenter)
            ) {
                Snackbar(
                    snackbarData = it,
                    containerColor = Color.Red,
                    contentColor = classicWhite,
                    shape = RoundedCornerShape(size = dimensions.roundedStandard)
                )
            }
        }
    }
}

@Preview
@Composable
fun SignUpScreenPreview() {
    SignUpScreen(
        viewModel = SignUpViewModel()
    )
}