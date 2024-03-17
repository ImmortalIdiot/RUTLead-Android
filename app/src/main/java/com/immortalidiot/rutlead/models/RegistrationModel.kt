package com.immortalidiot.rutlead.models

import android.provider.ContactsContract.CommonDataKinds.Email

data class RegistrationModel(
    val studentID: String,
    val studentEmail: String,
    val password: String,
    val studentName: String,
    val studentGroup: String
)
