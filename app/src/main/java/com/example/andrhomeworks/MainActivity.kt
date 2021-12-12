package com.example.andrhomeworks
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity(), OnButtonClicked {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    override fun setImage(image: Int) {
        val fragment2 = supportFragmentManager
            .findFragmentById(R.id.secondContainer) as? Fragment2
        fragment2?.getImage(image)
    }
}