package com.example.andrhomeworks

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity(), OnButtonClicked, OnButtonClicked2 {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onClick(text: String) {
        val fragment1 = supportFragmentManager.findFragmentById(R.id.firstContainer) as? Fragment1
        fragment1?.setText(text)
    }

    override fun onClick2(text2: String) {
        val fragment2 = supportFragmentManager.findFragmentById(R.id.secondContainer) as? Fragment2
        fragment2?.setText(text2)
    }
}