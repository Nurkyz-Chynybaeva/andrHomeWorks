package com.example.andrhomeworks

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity(), OnClicked {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction()
            .add(R.id.fragmentContainer, MainFragment())
            .commit()
    }

    override fun onClick(id: Long) {
        val fragment = DataFragment()
        val bundle = Bundle()
        bundle.putLong("keyId", id)
        fragment.arguments = bundle

        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, fragment)
            .addToBackStack(null)
            .commit()
    }
}








