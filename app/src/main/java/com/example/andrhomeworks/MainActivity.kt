package com.example.andrhomeworks

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatEditText
import androidx.appcompat.widget.AppCompatTextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val txt = findViewById<AppCompatTextView>(R.id.txt)
        val btn = findViewById<AppCompatButton>(R.id.btn)
        val edit = findViewById<AppCompatEditText>(R.id.edit)

        btn.setOnClickListener {

//            val editT = edit.text.toString()
//            val pattern = "\\w+".toRegex()
//            val words = pattern.findAll(editT)
//            txt.text = words.count().toString()
        }
    }
}









