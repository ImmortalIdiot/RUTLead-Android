package com.immortalidiot.rutlead.models

data class SignUpModel(
    val email: String,
    val studentID: String,
    val password: String,
    val group: String,
    val name: String,
    val isFocused: Boolean,
    val isPasswordVisible: Boolean
)