package com.example.andrhomeworks
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val adapter = Adapter()
        val recycler = findViewById<RecyclerView>(R.id.recyclerM1)

        recycler.adapter = adapter
        recycler.layoutManager = LinearLayoutManager(this)
        recycler.addItemDecoration(DividerItemDecoration(this, RecyclerView.VERTICAL))

        val list = mutableListOf<String>()
        for(i in 0..29) {
            list.add("item -$i")
        }
        adapter.setData(list)
    }
}