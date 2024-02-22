package com.immortalidiot.rutlead.presentation.validation

class ConfirmationPasswordValidator {
    fun execute(password: String, repeatedPassword: String): String? {

        return if (password != repeatedPassword) {
            "Пароли не совпадают"
        } else null
    }
}