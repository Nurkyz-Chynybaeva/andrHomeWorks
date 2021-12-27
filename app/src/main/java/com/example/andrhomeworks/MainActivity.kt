package com.example.andrhomeworks

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatEditText
import androidx.appcompat.widget.AppCompatTextView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val txt = findViewById<AppCompatTextView>(R.id.txt)
        val edit = findViewById<AppCompatEditText>(R.id.edit)
        val btn = findViewById<AppCompatButton>(R.id.btn)

        btn.setOnClickListener {
            val eTxt = edit.text.toString().trim()
            val count = eTxt.split("[a-zA-Z]*[oO][a-zA-Z]*".toRegex()).size - 1
            txt.text = count.toString()
        }
    }
}

