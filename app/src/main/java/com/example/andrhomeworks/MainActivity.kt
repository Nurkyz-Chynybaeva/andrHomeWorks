package com.example.andrhomeworks
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity(), OnItemClick {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction()
            .add(R.id.containerFrag, Fragment1())
            .commit()
    }

    override fun onClick(enteredText: String) {
        val fragment2 = Fragment2()

        val bundle = Bundle()
        bundle.putString("key", enteredText)
        fragment2.arguments = bundle

        supportFragmentManager.beginTransaction()
            .replace(R.id.containerFrag, fragment2)
            .addToBackStack(null)
            .commit()
    }

    override fun onClickButton(entered: String) {
        val bundle = Bundle()
        bundle.putString("keyB", entered)
        val intent = Intent()
    }
}