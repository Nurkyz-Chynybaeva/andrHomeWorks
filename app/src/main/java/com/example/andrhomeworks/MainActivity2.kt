package com.example.andrhomeworks

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.AppCompatButton

class MainActivity2 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val btn = findViewById<AppCompatButton>(R.id.btn)
        btn.setOnClickListener {
            val intent = Intent()
            intent.putExtra("KEY", "Hello from the second screen")
            setResult(RESULT_OK, intent)
            finish()
        }
    }
}