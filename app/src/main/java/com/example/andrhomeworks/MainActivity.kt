package com.example.andrhomeworks

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.andrhomeworks.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), OnClickButton {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportFragmentManager.beginTransaction()
            .add(R.id.container, RegistrationFragment())
            .commit()
    }

    override fun onClick() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.container, MainFragment())
            .commit()
    }
}








