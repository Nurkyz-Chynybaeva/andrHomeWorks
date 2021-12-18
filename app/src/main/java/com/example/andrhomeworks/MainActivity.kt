package com.example.andrhomeworks
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val recycler = findViewById<RecyclerView>(R.id.recyclerM1)

        val layoutManager = LinearLayoutManager(this)
        val adapter = Adapter { pos: Int ->
            val intent = Intent(Intent(this, MainActivity2::class.java))
            intent.putExtra("key", "item-$pos")
            startActivity(intent)
        }
        recycler.layoutManager = layoutManager
        recycler.adapter = adapter
        recycler.addItemDecoration(DividerItemDecoration(this, RecyclerView.VERTICAL))

        val list = mutableListOf<String>()
        for (i in 0..29) {
            list.add("item-$i")
        }
        adapter.setData(list)
    }

}