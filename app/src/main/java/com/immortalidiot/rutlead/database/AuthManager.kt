package com.immortalidiot.rutlead.database

import android.annotation.SuppressLint
import android.content.Context
import android.content.SharedPreferences

object AuthManager {

    private const val PREFERENCE_NAME = "auth"
    private const val SECRET_KEY =
        "26fe1746b40acf3f263de2736060b6dceeafb8e0b140de23d9f59dbf11764e41"

    private fun getPreferences(context: Context): SharedPreferences {
        return context.getSharedPreferences(
            PREFERENCE_NAME,
            Context.MODE_PRIVATE
        )
    }

    @SuppressLint("CommitPrefEdits")
    fun saveToken(context: Context, token: String) {
        getPreferences(context).edit().putString(SECRET_KEY, token).apply()
    }

    fun getToken(context: Context) : String? {
        return getPreferences(context).getString(SECRET_KEY, null)
    }

    fun clearToken(context: Context) {
        getPreferences(context).edit().remove(SECRET_KEY).apply()
    }

    fun isLoggedIn(context: Context) : Boolean {
        return getToken(context) != null
    }
}
