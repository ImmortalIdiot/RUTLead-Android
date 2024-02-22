package com.immortalidiot.rutlead.presentation.validation

class PasswordValidator {
    fun execute(password: String): String? {

        if (password.isBlank()) {
            return "Поле с паролем не должно быть пустым"
        }

        if (password.length < 8) {
            return "Пароль должен иметь длину не мешьше 8 символов"
        }

        val containsDigitsAndLetters = password.any { it.isDigit() } &&
                password.any { it.isLetter() }

        return if (containsDigitsAndLetters) {
            "Пароль должен содержать хотя бы одну букву и цифру"
        } else null
    }
}
