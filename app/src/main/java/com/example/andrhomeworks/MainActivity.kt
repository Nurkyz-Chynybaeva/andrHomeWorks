package com.example.andrhomeworks

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.AppCompatButton

class MainActivity : AppCompatActivity(), OpenFragments {
    private lateinit var prefs: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        getPreferences(MODE_PRIVATE)
        prefs = getSharedPreferences("AppPrefs", MODE_PRIVATE)

        if (prefs.getString("login", "def").isNullOrEmpty()) {
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
        val corLog = prefs.getString("login", "def")
        val corPas = prefs.getString("password", "def")
        if (corLog == login && corPas == password) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, MainScreen())
                .addToBackStack(null)
                .commit()
        } else {
            val changeBtn = findViewById<AppCompatButton>(R.id.change_btn)
            changeBtn.visibility = View.VISIBLE
            changeBtn.setOnClickListener {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.container, RegistrationFragment())
                    .commit()
            }
        }
    }
}