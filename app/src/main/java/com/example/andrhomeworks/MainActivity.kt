package com.example.andrhomeworks
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity(), Back{
    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager.beginTransaction()
            .add(R.id.fragmentContainer, MainFragment())
            .commit()
    }
    override fun backFragment() {
        supportFragmentManager.beginTransaction()
            .add(R.id.fragmentContainer, AboutFragment())
            .commit()
    }
}