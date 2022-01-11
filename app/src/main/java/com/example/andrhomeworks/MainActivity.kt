package com.example.andrhomeworks

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton

class MainActivity : AppCompatActivity(), CheckPref {
    private lateinit var prefs: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        getPreferences(MODE_PRIVATE)
        prefs = getSharedPreferences("AppPrefs", MODE_PRIVATE)

        if (prefs.getString(LOGKEY, PASKEY).isNullOrEmpty()) {
            supportFragmentManager.beginTransaction()
                .add(R.id.container, RegistrationFragment())
                .commit()
        } else {
            supportFragmentManager.beginTransaction()
                .add(R.id.container, AuthorisationFragment())
                .commit()
        }
    }

    override fun changePrefs(login: String, password: String) {
        val editor = prefs.edit()
        editor.putString("login", login).apply()
        editor.putString("password", password).apply()

        supportFragmentManager.beginTransaction()
            .replace(R.id.container, AuthorisationFragment())
            .commit()
    }

    override fun checkPrefs(login: String, password: String) {
        val loginCheck = prefs.getString("login", "default")
        val passwordCheck = prefs.getString("password", "default")
        if (loginCheck == login && passwordCheck == password) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, MainFragment())
                .addToBackStack(null)
                .commit()
        } else {
            Toast.makeText(this, "register please", Toast.LENGTH_SHORT).show()
            val btn2 = findViewById<AppCompatButton>(R.id.btn2Aut)
            btn2.setOnClickListener {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.container, RegistrationFragment()).commit()
            }
        }
    }
    companion object{
        const val LOGKEY = "loginkey"
        const val PASKEY = "passwordkey"
    }
}

