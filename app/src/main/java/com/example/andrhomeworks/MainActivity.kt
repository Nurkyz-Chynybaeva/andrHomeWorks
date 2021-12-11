package com.example.andrhomeworks

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.widget.Toolbar


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toolbar =
            findViewById<Toolbar>(R.id.toolbar)      //указали toolbar вместо actionBar и все свойства
        setSupportActionBar(toolbar)                           //actionBar активити передаст к Toolbar
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
//        menu?.add("menu 10")                                       //програмно создали
//        menu?.add("menu 20")
//        menu?.add("menu 30")
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {    //этот метод вызывается тогда, когда кликаем на пункты меню
        when (item.itemId) {
            R.id.menu1 -> {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.fragmentContainer, Fragment1())
                    .commit()
            }
            R.id.menu2 -> {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.fragmentContainer, Fragment2())
                    .commit()
            }

            else -> {
            }
        }
        Toast.makeText(this, item.title, Toast.LENGTH_SHORT).show()
        return super.onOptionsItemSelected(item)
    }

}
