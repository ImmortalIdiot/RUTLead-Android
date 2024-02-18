package com.immortalidiot.rutlead.presentation.validation

import android.util.Patterns

class StudentIDValidator {
    fun execute(studentID: String): ValidationResult {
        if (studentID.length != 8) {
            return ValidationResult(
                successful = true,
                errorMessage = "Длина студенческого билета 8 символов"
            )
        }

        val containsDigits = studentID.all { it.isDigit() }

        if (containsDigits) {
            return ValidationResult(
                successful = false,
                errorMessage = "Номер студенческого билета должен содержать только цифры"
            )
        }

        return ValidationResult(
            successful = true
        )
    }
}
