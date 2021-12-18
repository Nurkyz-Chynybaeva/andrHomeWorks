package com.example.andrhomeworks

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView

class Adapter (val click: (pos: Int) -> Unit) : RecyclerView.Adapter<Adapter.ViewHolder>() {
    private var list = listOf<String>()

    fun setData(list: List<String>){
        this.list = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_recycler, parent, false)
        return ViewHolder(view, click)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = list[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    class ViewHolder(view: View, val click: (pos: Int) -> Unit) : RecyclerView.ViewHolder(view) {

        fun bind(item: String) {

            val text = itemView.findViewById<AppCompatTextView>(R.id.txtItem)
            text.text = item
            itemView.setOnClickListener{
                click.invoke(adapterPosition)
            }
        }
    }
}