package com.example.andrhomeworks

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.AppCompatTextView

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val text = findViewById<AppCompatTextView>(R.id.txtM2)
        val txt = intent.getStringExtra("key2")
        text.text = txt
    }
}