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

        val txt = findViewById<AppCompatTextView>(R.id.txt)
        val edit = findViewById<AppCompatEditText>(R.id.edit)
        val btn = findViewById<AppCompatButton>(R.id.btn)

        btn.setOnClickListener {
                val `in` = Scanner(System.`in`)
                val w = `in`.nextLine() + " "
                var z = ""
                val v = "aА"
                var ww = ""
                var cc = 0
                var cl = 0
                for (element in w) {
                    val c = element
                    if (c.code != 20) z += c else {
                        for (element in w) {
                            val d = element
                            if (v.indexOf(d) != -1) cc++
                        }
                        if (cc > cl) {
                            ww = z
                            cl = cc
                        }
                        z = ""
                        cc = 0
                    }
                }
                val eTxt = edit.text.toString()
                val count = eTxt == ww
                txt.text = count.toString()
            }
        }
    }
