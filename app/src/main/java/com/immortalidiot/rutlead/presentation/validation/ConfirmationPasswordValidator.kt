package com.immortalidiot.rutlead.presentation.validation

class ConfirmationPasswordValidator {
    fun execute(password: String, repeatedPassword: String): ValidationResult {
        if (password != repeatedPassword) {
            return ValidationResult(
                successful = false,
                errorMessage = "Пароли не совпадают"
            )
        }
        return ValidationResult(
            successful = true
        )
    }
}