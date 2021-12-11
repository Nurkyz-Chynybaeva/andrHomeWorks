package com.example.andrhomeworks

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity(), Navigator {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction()
            .add(R.id.container, Fragment1())
            .commit()
    }

    override fun showFragment2(userName: String, userPassword: String) {
        val fragment2 = Fragment2()
//        val bundle = Bundle()
//        bundle.putString("keyL", userName)
//        bundle.putString("keyP", userPassword)
//        fragment2.arguments = bundle

        supportFragmentManager.beginTransaction()
            .replace(R.id.container, fragment2)
            .commit()
    }

}