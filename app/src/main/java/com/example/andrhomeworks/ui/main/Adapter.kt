package com.example.andrhomeworks.ui.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.andrhomeworks.R
import com.example.andrhomeworks.data.models.CharacterEntity
import com.example.andrhomeworks.databinding.ItemRecyclerBinding

class Adapter(private val click: (character: CharacterEntity) -> Unit) :
    RecyclerView.Adapter<Adapter.ViewHolder>() {
    private var list: List<CharacterEntity> = mutableListOf()

    fun setData(list: List<CharacterEntity>) {
        this.list = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_recycler, parent, false)
        val binding = ItemRecyclerBinding.bind(itemView)
        return ViewHolder(click, binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = list[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int {
        return list.size
    }


    class ViewHolder(
        private val click: (character: CharacterEntity) -> Unit,
        private val binding: ItemRecyclerBinding,
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(character: CharacterEntity) {
            binding.apply {
                Glide.with(itemView.context)
                    .load(character.image)
                    .into(imgItem)
                txtNameItem.text = character.name
                txtStatusItem.text = character.status
                txtSpeciesItem.text = character.species
            }

            itemView.setOnClickListener {
                click.invoke(character)
            }
        }
    }
}