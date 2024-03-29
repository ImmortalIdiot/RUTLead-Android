package com.immortalidiot.rutlead.ui.models

data class ResetPasswordModel(
    val email: String,
    val password: String,
    val confirmPassword: String,
    val isFocused: Boolean,
    val isPasswordVisible: Boolean
)
