package com.example.andrhomeworks

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity(), Back{
    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager.beginTransaction()
            .add(R.id.fragmentContainer, Fragment1())
            .commit()
    }

    override fun backFragment() {
        supportFragmentManager.beginTransaction()
            .add(R.id.fragmentContainer, Fragment2())
            .commit()
    }
}