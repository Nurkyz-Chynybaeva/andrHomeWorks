package com.example.andrhomeworks.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.andrhomeworks.R

class MainActivity : AppCompatActivity(), OnClicked {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
    }

    override fun openFragment(fragment: Fragment) {
        TODO("Not yet implemented")
    }
}