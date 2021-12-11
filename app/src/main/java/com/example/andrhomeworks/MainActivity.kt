package com.example.andrhomeworks

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity(), OnClickButton {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction()
            .add(R.id.container, Fragment1())
            .commit()
    }

    override fun onClick(name: String, password: String) {
        supportFragmentManager.beginTransaction()
            .add(R.id.container, Fragment2())
            .commit()
    }

}