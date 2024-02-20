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
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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

    SnackbarHost(snackbarHostState)

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
                errorText = when (state) {
                    is SignUpViewModel.State.Error ->
                        "Некорректный номер студенческого билета"

                    is SignUpViewModel.State.ValidationError -> {
                        (state as? SignUpViewModel.State.ValidationError)?.studentIDError
                    }

                    else -> null
                },
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
                errorText = when (state) {
                    is SignUpViewModel.State.Error ->
                        "Длина пароля должна быть не менее 8 символов"

                    is SignUpViewModel.State.ValidationError -> {
                        (state as? SignUpViewModel.State.ValidationError)?.passwordError
                    }

                    else -> null
                },
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
                errorText = when (state) {
                    is SignUpViewModel.State.Error ->
                        "Пароли не совпадают"

                    is SignUpViewModel.State.ValidationError -> {
                        (state as? SignUpViewModel.State.ValidationError)?.confirmationPasswordError
                    }

                    else -> null
                },
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
//                    val viewModelState = (state as? SignUpViewModel.State.ValidationError)
//                    Log.d("Screen", state.toString())
//                    Log.d("Screen", "${viewModelState?.studentIDError}, ${viewModelState?.passwordError}")

                        val msg: String = when {
                            (state is SignUpViewModel.State.Error) -> {
                                "Ошибка сервера"
                            }

                            (state is SignUpViewModel.State.Success) -> {
                                "Успешный вход"
                            }

                            (state is SignUpViewModel.State.ValidationError
                                    && (state as SignUpViewModel.State.ValidationError).studentIDError != null) -> {
                                "Неверный студак"
                            }

                            (state is SignUpViewModel.State.ValidationError
                                    && (state as SignUpViewModel.State.ValidationError).passwordError != null) -> {
                                "Некорректный пароль"
                            }

                            (state is SignUpViewModel.State.ValidationError
                                    && (state as SignUpViewModel.State.ValidationError).confirmationPasswordError != null) -> {
                                "Пароли не совпадают"
                            }

                            else -> {
                                "123"
                            }
                        }

                        snackbarHostState.showSnackbar(
                            message = msg,
                            actionLabel = null,
                            withDismissAction = false,
                            duration = SnackbarDuration.Short
                        )
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
            )
        }

//        LaunchedEffect(state) {
//            val viewModelState = (state as? SignUpViewModel.State.ValidationError)
//            when (state) {
//                is SignUpViewModel.State.Error -> {
//                    (state as SignUpViewModel.State.Error).message?.also { message ->
//                        snackbarHostState.showMessage(message = message)
//                    }
//                }
//
//                SignUpViewModel.State.Success -> {
//                    // TODO: switch to Main screen
//                }
//
//                else -> { /* do nothing */
//                }
//            }
//        }
//            when {
//                (state is SignUpViewModel.State.Error) -> {
//                    launch { snackbarHostState.showSnackbar("Ошибка сервера!") }
//                }
//
//                (state is SignUpViewModel.State.Success) -> {
//                    launch { snackbarHostState.showSnackbar(
//                        message = "Успешный вход",
//                        ) }
//                }
//                // TODO: switch to Main FLow
//                (viewModelState?.studentIDError != null) -> {
//                    launch { snackbarHostState.showMessage("Неверный номер студенческого билета") }
//                }
//
//                (viewModelState?.passwordError != null) -> {
//                    launch { snackbarHostState.showSnackbar("Длина пароля должна быть не менее 8 символов") }
//                }
//
//                (viewModelState?.confirmationPasswordError != null) ->
//                    launch { snackbarHostState.showSnackbar("Пароли не совпадают") }
//
//                else -> { /* Do nothing */
//                }
//            }
//                launch {
//
//                    snackbarHostState.showSnackbar("Снэкбар")
//                }
    }
}


@Preview
@Composable
fun SignUpScreenPreview() {
    SignUpScreen(
        viewModel = SignUpViewModel()
    )
}