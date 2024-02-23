package com.immortalidiot.rutlead.presentation.viewmodels

import androidx.compose.runtime.Immutable
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.immortalidiot.rutlead.presentation.validation.validateConfirmationPassword
import com.immortalidiot.rutlead.presentation.validation.validatePassword
import com.immortalidiot.rutlead.presentation.validation.validateStudentID
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

    fun clearErrorStack() {
        mutableState.update {
            State.Init
        }
    }

    fun request() {

        val studentID = _uiState.value.studentID.validateStudentID()
        val password = _uiState.value.password.validatePassword()
        val confirmationPassword =
            _uiState.value.confirmationPassword
                .validateConfirmationPassword(password = _uiState.value.password)

        if (studentID.isFailure
            || password.isFailure
            || confirmationPassword.isFailure
        ) {
            viewModelScope.launch {
                mutableState.update {
                    State.ValidationError(
                        studentIDError = studentID.exceptionOrNull()?.message,
                        passwordError = password.exceptionOrNull()?.message,
                        confirmationPasswordError = confirmationPassword.exceptionOrNull()?.message
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
}
