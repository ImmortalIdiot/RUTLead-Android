package com.immortalidiot.rutlead.presentation.validation

class StudentIDValidator {
    fun execute(studentID: String): String? {

        if (studentID.isEmpty() || studentID.isBlank()) {
            return "Поле \"Номер студенческого билета\" не должно быть пустым"
        }

        if (studentID.length != 8) {
            return "Длина студенческого билета 8 символов"
        }

        val containsDigits = studentID.all { it.isDigit() }

        return if (!containsDigits) {
            "Номер студенческого билета должен содержать только цифры"
        } else null
    }
}
