package com.immortalidiot.rutlead.viewmodels

import android.provider.ContactsContract.CommonDataKinds.Email
import androidx.compose.runtime.Immutable
import com.immortalidiot.rutlead.models.RegistrationModel
import com.immortalidiot.rutlead.validation.validatePassword
import com.immortalidiot.rutlead.validation.validateStudentEmail
import com.immortalidiot.rutlead.validation.validateStudentGroup
import com.immortalidiot.rutlead.validation.validateStudentID
import com.immortalidiot.rutlead.validation.validateStudentName
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class RegistrationScreenViewModel {

    @Immutable
    sealed class State {
        object Init : State()
        object Success : State()
        object Loading : State()
        data class Error(val message: String) : State()
        data class ValidationError(
            val studentIDError: String?,
            val studentEmailError: String?, //TODO: make Email Type
            val passwordError: String?,
            val studentNameError: String?,
            val studentGroupError: String?
        ) : State()
    }

    var mutableState = MutableStateFlow<State>(State.Init)
        private set

    private val _uiRegState = MutableStateFlow(
        RegistrationModel(
            studentID = String(),
            studentEmail = String(),
            password = String(),
            studentName = String(),
            studentGroup = String()
        )
    )

    val uiRegState: StateFlow<RegistrationModel> = _uiRegState.asStateFlow()

    fun clearErrorStack() {
        mutableState.update {
            State.Init
        }
    }
    fun changeId(studentID: String) {
        _uiRegState.update {
            uiRegState.value.copy(studentID = studentID)
        }
    }
    fun changeEmail(studentEmail: String) {
        _uiRegState.update {
            uiRegState.value.copy(studentEmail = studentEmail)
        }
    }
    fun changePassword(password: String) {
        _uiRegState.update {
            uiRegState.value.copy(password = password)
        }
    }
    fun changeName(studentName: String) {
        _uiRegState.update {
            uiRegState.value.copy(studentName = studentName)
        }
    }
    fun changeGroup(studentGroup: String) {
        _uiRegState.update {
            uiRegState.value.copy(studentGroup = studentGroup)
        }
    }

    fun request() {
        val studentID = _uiRegState.value.studentID.validateStudentID()
        val studentEmail = _uiRegState.value.studentID.validateStudentEmail()
        val password = _uiRegState.value.password.validatePassword()
        val studentName = _uiRegState.value.studentName.validateStudentName()
        val studentGroup = _uiRegState.value.studentGroup.validateStudentGroup()

        if (studentID.isFailure || password.isFailure || studentEmail.isFailure) {
            mutableState.update {
                State.ValidationError(
                    studentIDError = studentID.exceptionOrNull()?.message,
                    studentEmailError = studentEmail.exceptionOrNull()?.message,
                    passwordError = password.exceptionOrNull()?.message,
                    studentNameError = studentName.exceptionOrNull()?.message,
                    studentGroupError = studentGroup.exceptionOrNull()?.message
                )
            }
        }
    }
}
