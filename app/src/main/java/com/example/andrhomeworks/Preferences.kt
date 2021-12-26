package com.example.andrhomeworks

import android.content.Context
import android.provider.Settings.Global.putString
import java.util.prefs.Preferences


class Preference() {
//    private val preferences = getSharedPreferences("prf", Context.MODE_PRIVATE)
//
//     fun saveLogin(login: String) {
//        preferences.edit().apply {
//            putString(LOGIN_KEY, login)
//        }.apply()
//    }


    companion object {
        const val LOGIN_KEY = "KEYL"
        const val PASSWORD_KEY = "KEYP"
    }
}