package com.example.andrhomeworks

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.andrhomeworks.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), OnClickButton {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportFragmentManager.beginTransaction()
            .add(R.id.container, MainFragment())
            .commit()
    }

    override fun onClick() {
        supportFragmentManager.beginTransaction()
            .add(R.id.container, MainFragment())
            .commit()
    }

    override fun addEmployee() {
        supportFragmentManager.beginTransaction()
            .add(R.id.container, AddEmplFragment())
            .commit()
    }

    override fun initDataFragment(id: Long) {
        val fragment = DataFragment()
        val bundle = Bundle()
        bundle.putLong("KEY_ID", id)
        fragment.arguments = bundle
        supportFragmentManager.beginTransaction()
            .add(R.id.container, fragment)
            .commit()
    }

    override fun editUser(id: Long) {
        val fragment = EditUserFragment()
        val bundle = Bundle()
        bundle.putLong("KEY", id)
        fragment.arguments = bundle
        supportFragmentManager.beginTransaction()
            .add(R.id.container, fragment)
            .commit()
    }
}