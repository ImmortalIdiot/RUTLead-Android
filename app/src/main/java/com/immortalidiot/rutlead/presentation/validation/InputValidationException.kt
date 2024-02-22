package com.immortalidiot.rutlead.presentation.validation

class InputValidationException(message: String) : Exception(message)

fun validateStudentID(studentID: String): String? {
    return try {
        val containsOnlyDigits = studentID.all { it.isDigit() }

        if (studentID.isBlank()) {
            throw InputValidationException("Поле \"Номер студенческого билета\" не должно быть пустым")
        } else if (!containsOnlyDigits) {
            throw InputValidationException("Номер студенческого билета должен содержать только цифры")
        } else if (studentID.length != 8) {
            throw InputValidationException("Номер студенческого билета состоит из 8 цифр")
        } else null

    } catch (e: InputValidationException) {
        e.message
    }
}

fun validatePassword(password: String): String? {
    return try {
        if (password.isBlank()) {
            throw InputValidationException("Поле с паролем не должно быть пустым")
        } else if (password.length < 8) {
            throw InputValidationException("Длина пароля должна быть не менее 8 символов")
        } else null

    } catch (e: InputValidationException) {
        e.message
    }
}

fun validateConfirmationPassword(
    password: String,
    confirmationPassword: String
) : String? {
    return try {
        if (password.isNotBlank() && password != confirmationPassword) {
            throw InputValidationException("Пароли не совпадают")
        } else null
    } catch (e: InputValidationException) {
        e.message
    }
}