package com.example.andrhomeworks

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatEditText
import androidx.appcompat.widget.AppCompatTextView
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn = findViewById<AppCompatButton>(R.id.btn)
        btn.setOnClickListener {
            val txt = findViewById<AppCompatTextView>(R.id.txt)
            val edit = findViewById<AppCompatEditText>(R.id.edit)
            val eTxt = edit.text.toString()

            val `in` = Scanner(System.`in`)
            val w = `in`.nextLine() + " "
            var z = ""
            val v = "aA"
            var ww = ""
            var cc = 0
            var cl = 0
            for (element in w) {
                val c = element
                if (c.code != 32) z += c else {
                    for (element in w) {
                        if (v.indexOf(element) != -1) cc++
                    }
                    if (cc > cl) {
                        ww = z
                        cl = cc
                    }
                    z = ""
                    cc = 0
                }
            }
        }

    }
}




