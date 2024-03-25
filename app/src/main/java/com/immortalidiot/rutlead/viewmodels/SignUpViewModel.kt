package com.immortalidiot.rutlead.viewmodels

import androidx.compose.runtime.Immutable
import androidx.lifecycle.ViewModel
import com.immortalidiot.rutlead.models.SignUpModel
import com.immortalidiot.rutlead.validation.validateEmail
import com.immortalidiot.rutlead.validation.validateGroup
import com.immortalidiot.rutlead.validation.validateName
import com.immortalidiot.rutlead.validation.validatePassword
import com.immortalidiot.rutlead.validation.validateStudentID
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class SignUpViewModel : ViewModel() {
    @Immutable
    sealed class State {
        object Init : State()
        object Success : State()
        object Loading : State()
        object SecondPart : State()
        data class Error(val message: String) : State()
        data class SignUpValidationFirstPartError(
            val studentIDError: String?,
            val emailError: String?,
            val passwordError: String?,
        ) : State()
        data class SignUpValidationSecondPartError(
            val groupError: String?,
            val nameError: String?
        ) : State()
    }

    var mutableState = MutableStateFlow<State>(State.Init)
        private set

    private val _uiState = MutableStateFlow(
        SignUpModel(
            email = String(),
            studentID = String(),
            password = String(),
            group = String(),
            name = String(),
            isFocused = false,
            isPasswordVisible = true
        )
    )

    val uiState: StateFlow<SignUpModel> = _uiState.asStateFlow()

    fun clearErrorStackInFirstPart() {
        mutableState.update {
            State.Init
        }
    }

    fun clearErrorStackInSecondPart() {
        mutableState.update {
            State.SecondPart
        }
    }

    fun changeEmail(email: String) {
        _uiState.update {
            uiState.value.copy(email = email)
        }
    }

    fun changeStudentID(studentID: String) {
        _uiState.update {
            uiState.value.copy(studentID = studentID)
        }
    }

    fun changePassword(password: String) {
        _uiState.update {
            uiState.value.copy(password = password)
        }
    }

    fun changeGroup(group: String) {
        _uiState.update {
            uiState.value.copy(group = group)
        }
    }

    fun changeName(name: String) {
        _uiState.update {
            uiState.value.copy(name = name)
        }
    }

    fun changePasswordVisibility(isVisible: Boolean) {
        _uiState.update {
            uiState.value.copy(isPasswordVisible = !isVisible)
        }
    }

    fun updateScreen() {
        val email = _uiState.value.email.validateEmail()
        val studentID = _uiState.value.studentID.validateStudentID()
        val password = _uiState.value.password.validatePassword()

        if (email.isFailure || studentID.isFailure || password.isFailure) {
            mutableState.update {
                State.SignUpValidationFirstPartError(
                    emailError = email.exceptionOrNull()?.message,
                    studentIDError = studentID.exceptionOrNull()?.message,
                    passwordError = password.exceptionOrNull()?.message,
                )
            }
        } else {
            mutableState.value = State.SecondPart
        }
    }

    fun register() {
        val group = _uiState.value.group.validateGroup()
        val name = _uiState.value.name.validateName()

        if (group.isFailure || name.isFailure) {
            mutableState.update {
                State.SignUpValidationSecondPartError(
                    groupError = group.exceptionOrNull()?.message,
                    nameError = name.exceptionOrNull()?.message
                )
            }
        } else {
            mutableState.update {
                State.Success
            }
            // TODO: register the user
        }
    }
}
