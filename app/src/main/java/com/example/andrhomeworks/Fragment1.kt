package com.example.andrhomeworks

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class Fragment1 : Fragment(R.layout.fragment1) {
    private lateinit var listener: OnItemClick
    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = context as OnItemClick
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val recycler = view.findViewById<RecyclerView>(R.id.recycler)
        val adapter = Adapter {
            val text = "item - $it"
            listener.onClick(text)
        }
        recycler.layoutManager = GridLayoutManager(requireContext(), 2)
        recycler.adapter = adapter
        val list = mutableListOf<String>()
        for (i in 0..29) {
            list.add("item - $i")
        }
        adapter.setData(list)
    }
}