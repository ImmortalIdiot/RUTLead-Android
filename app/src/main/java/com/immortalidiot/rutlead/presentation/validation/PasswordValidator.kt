package com.immortalidiot.rutlead.presentation.validation

class PasswordValidation {
    fun execute(password: String): ValidationResult {
        if (password.length < 8) {
            return ValidationResult(
                successful = false,
                errorMessage = "Пароль должен иметь длину не мешьше 8 символов"
            )
        }

        val containsDigitsAndLetters = password.any { it.isDigit() } &&
                password.any { it.isLetter() }

        if (containsDigitsAndLetters) {
            ValidationResult(
                successful = false,
                errorMessage = "Пароль должен содержать хотя бы одну букву и цифру"
            )
        }

        return ValidationResult(
            successful = true
        )
    }
}
