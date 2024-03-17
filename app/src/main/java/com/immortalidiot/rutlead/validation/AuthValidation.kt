package com.immortalidiot.rutlead.validation

class AuthValidationException(message: String) : Exception(message)

fun String.validateStudentID(): Result<Unit> {
    val containsOnlyDigits = this.all { char ->
        char.isDigit()
    }

    return if (this.isNotBlank() && containsOnlyDigits && this.length == 8) {
        Result.success(Unit)
    } else if (this.isBlank()) {
        Result.failure(
            AuthValidationException(
                "Поле \"Номер студенческого билета\" не должно быть пустым"
            )
        )
    } else if (!containsOnlyDigits) {
        Result.failure(
            AuthValidationException(
                "Поле \"Номер студенческого билета\" должно содержать только цифры"
            )
        )
    } else {
        Result.failure(
            AuthValidationException(
                "Номер студенческого билета состоит из 8 цифр"
            )
        )
    }
}

fun String.validatePassword(): Result<Boolean> {
    return if (this.isNotBlank() && this.length >= 8) {
        Result.success(true)
    } else if (isBlank()) {
        Result.failure(
            AuthValidationException(
                "Поле \"Пароль\" не должно быть пустым"
            )
        )
    } else {
        Result.failure(
            AuthValidationException(
                "Пароль должен содержать минимум 8 символов"
            )
        )
    }
}

fun String.validateStudentEmail(): Result<Unit> {
    // TODO: validate Email
    return Result.success(Unit)
}

fun String.validateStudentName(): Result<Unit> {
   // TODO: validate Name
    return Result.success(Unit)
}

fun String.validateStudentGroup(): Result<Unit> {
  //  TODO: validate Group
    return Result.success(Unit)
}
