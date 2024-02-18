package com.immortalidiot.rutlead.presentation.validation

import androidx.compose.runtime.Immutable

@Immutable
data class ValidationResult(
    val successful: Boolean,
    val errorMessage: String? = null
)
