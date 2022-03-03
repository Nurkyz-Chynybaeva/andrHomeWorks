package com.example.andrhomeworks

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView


class Adapter(private val click: (episode: Episode) -> Unit): RecyclerView.Adapter<Adapter.ViewHolder>() {
    private var list: List<Episode> = mutableListOf()
    lateinit var seriesApi: SeriesApi

    fun setData(list: List<Episode>) {
        this.list = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_recycler, parent, false)
        return ViewHolder(itemView, click)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = list[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    class ViewHolder(itemView: View,
                     private val click: (episode: Episode) -> Unit): RecyclerView.ViewHolder(itemView) {
        fun bind(item: Episode) {
            val txtName = itemView.findViewById<AppCompatTextView>(R.id.txtNameItem)
            val txtStatus = itemView.findViewById<AppCompatTextView>(R.id.txtStatusItem)
            val txtSpecies = itemView.findViewById<AppCompatTextView>(R.id.txtSpeciesItem)
            val txtLocationName = itemView.findViewById<AppCompatTextView>(R.id.txtLocationNameItem)
            val txtLocationUrl = itemView.findViewById<AppCompatTextView>(R.id.txtLocationUrlItem)

            txtName.text = item.name
            txtStatus.text = item.status
            txtSpecies.text = item.species
            txtLocationName.text = item.location.name
            txtLocationUrl.text = item.location.url

            itemView.setOnClickListener {
                click.invoke(item)
            }
        }
    }
}