package com.immortalidiot.rutlead.viewmodels

import androidx.compose.runtime.Immutable
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.immortalidiot.rutlead.models.LoginModel
import com.immortalidiot.rutlead.validation.validatePassword
import com.immortalidiot.rutlead.validation.validateStudentID
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class LoginScreenViewModel : ViewModel() {
    @Immutable
    sealed class State {
        object Init : State()
        object Success : State()
        object Loading : State()
        data class Error(val message: String) : State()
        data class ValidationError(
            val studentIDError: String?,
            val passwordError: String?
        ) : State()
    }

    var mutableState = MutableStateFlow<State>(State.Init)
        private set

    private val _uiState = MutableStateFlow(
        LoginModel(
            studentID = String(),
            password = String(),
            isPasswordVisible = true
        )
    )

    val uiState: StateFlow<LoginModel> = _uiState.asStateFlow()

    fun clearErrorStack() {
        mutableState.update {
            State.Init
        }
    }
    fun changeLogin(studentID: String) {
        _uiState.update {
            uiState.value.copy(studentID = studentID)
        }
    }

    fun changePassword(password: String) {
        _uiState.update {
            uiState.value.copy(password = password)
        }
    }

    fun changePasswordVisibility(isPasswordVisible: Boolean) {
        _uiState.update {
            uiState.value.copy(isPasswordVisible = !isPasswordVisible)
        }
    }

    fun request() {
        val studentID = _uiState.value.studentID.validateStudentID()
        val password = _uiState.value.password.validatePassword()

        if (studentID.isFailure || password.isFailure) {
            mutableState.update {
                State.ValidationError(
                    studentIDError = studentID.exceptionOrNull()?.message,
                    passwordError = password.exceptionOrNull()?.message
                )
            }
        } else {
            viewModelScope.launch {
                mutableState.value = State.Loading
                // TODO: add verification for an existing user in the database

                mutableState.value = State.Success
            }
        }
    }
}
