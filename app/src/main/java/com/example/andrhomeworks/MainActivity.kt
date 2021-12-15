package com.example.andrhomeworks
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
class MainActivity : AppCompatActivity(), OnClickButton {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction()
            .add(R.id.container, Fragment1())
            .commit()
    }
    override fun onClick(name: String, password: String) {
        val fragment2 = Fragment2()
        val bundle = Bundle()
        bundle.putString("text", name)
        bundle.putString("number", password)
        fragment2.arguments = bundle
        supportFragmentManager.beginTransaction()
            .add(R.id.container, fragment2)
            .addToBackStack(null)
            .commit()
    }
}