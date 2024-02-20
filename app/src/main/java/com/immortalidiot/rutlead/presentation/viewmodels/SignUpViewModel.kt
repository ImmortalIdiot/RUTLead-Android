package com.immortalidiot.rutlead.presentation.viewmodels

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.immortalidiot.rutlead.presentation.validation.ConfirmationPasswordValidator
import com.immortalidiot.rutlead.presentation.validation.PasswordValidation
import com.immortalidiot.rutlead.presentation.validation.StudentIDValidator
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class SignUpViewModel() : ViewModel() {

    @Immutable
    sealed class State {
        object Init : State()
        object Success : State()
        object Loading : State()
        data class Error(val message: String) : State()
        data class ValidationError(
            val studentIDError: String?,
            val passwordError: String?,
            val confirmationPasswordError: String?
        ) : State()
    }
    // if request from server - @Serializable
    // if request from local server - without @Serializable

    data class RegisterModel(
        val studentID: String,
        val password: String,
        val confirmationPassword: String
    ) {
        companion object {
            val initial
                get() = RegisterModel(
                    studentID = String(),
                    password = String(),
                    confirmationPassword = String()
                )
        }
    }

    private val _uiState: MutableStateFlow<RegisterModel> =
        MutableStateFlow(RegisterModel.initial)

    val uiState: StateFlow<RegisterModel> = _uiState.asStateFlow()

    var mutableState = MutableStateFlow<State>(State.Init)
        private set

    fun changeStudentID(studentID: String) {
        _uiState.update {
            it.copy(studentID = studentID)
        }
    }

    fun changePassword(password: String) {
        _uiState.update {
            it.copy(password = password)
        }
    }

    fun changeConfirmationPassword(confirmationPassword: String) {
        _uiState.update {
            it.copy(confirmationPassword = confirmationPassword)
        }
    }

    fun request() {
        val studentID = validateStudentID(_uiState.value.studentID)
        val password = validatePassword(_uiState.value.password)
        val confirmationPassword = validateConfirmationPassword(
            password = _uiState.value.password,
            confirmationPassword = _uiState.value.confirmationPassword
        )

        if (studentID != null
            || password != null
            || confirmationPassword != null) {

            viewModelScope.launch {
                mutableState.update {
                    State.ValidationError(
                        studentIDError = studentID,
                        passwordError = password,
                        confirmationPasswordError = confirmationPassword
                    )
                }
            }
        } else {
            mutableState.update {
                State.Success
                    // TODO: switch to Main screen
            }
        }
    }

    private fun validateStudentID(studentID: String): String? {
        return if (studentID.isBlank())
            "Поле \"Номер студенческого билета\" не должно быть пустым"
        else if (!studentID.all { it.isDigit() })
            "Поле \"Номер студенческого билета\" должно состоять только из цифр"
        else if (studentID.length != 8)
            "Номер студенческого билета состоит из 8 символов"
        else null

    }

    private fun validatePassword(password: String): String? {
        return if (password.isBlank())
            "Поле пароля не должно быть пустым"
        else if (password.length < 8)
            "Пароль должен состоять не менее, чем из 8 символов"
        else null
    }

    private fun validateConfirmationPassword(
        password: String,
        confirmationPassword: String
    ): String? {
        return if (password != confirmationPassword)
            "Пароли не совпадают"
        else null
    }
}
