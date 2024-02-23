package com.immortalidiot.rutlead.presentation.validation

class InputValidationException(message: String) : Exception(message)

fun String.validateStudentID(): Result<Boolean> {
    val containsOnlyDigits = this.all { it.isDigit() }

    return if (this.isNotBlank() && containsOnlyDigits && this.length == 8) {
        Result.success(true)
    } else if (this.isBlank()) {
        Result.failure(InputValidationException("Поле \"Номер студенческого билета\" не должно быть пустым"))
    } else if (!containsOnlyDigits) {
        Result.failure(InputValidationException("Номер студенческого билета должен содержать только цифры"))
    } else {
        Result.failure(InputValidationException("Номер студенческого билета состоит из 8 цифр"))
    }
}

fun String.validatePassword(): Result<Boolean> {
    return if (this.isNotBlank() && this.length >= 8) {
        Result.success(true)
    } else if (this.isBlank()) {
        Result.failure(InputValidationException("Поле с паролем не должно быть пустым"))
    } else {
        Result.failure(InputValidationException("Длина пароля должна быть не менее 8 символов"))
    }
}

fun String.validateConfirmationPassword(password: String): Result<Boolean> {
    return if (password.isNotBlank() && this == password) {
        Result.success(true)
    } else {
        Result.failure(InputValidationException("Пароли не совпадают"))
    }
}