package com.example.andrhomeworks

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
class Adapter : RecyclerView.Adapter<Adapter.ViewHolder>() {
    private var list = listOf<String>()
    fun setData(list: List<String>) {
        this.list = list
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_recycler, parent, false)
        return ViewHolder(itemView)
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val text = list[position]
        holder.bind(text)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        private val firstImg = "https://www.digitalmarketingcommunity.com/wp-content/uploads/2019/12/SmallBizGenius-logo.png"
        private val secondImg = "https://cdn.pixabay.com/photo/2019/06/13/09/41/business-4271251_1280.png"
        fun bind(text: String) {
            val txt = itemView.findViewById<AppCompatTextView>(R.id.txtItem)
            txt.text = text
            val image = itemView.findViewById<AppCompatImageView>(R.id.imgItem)
            if (adapterPosition % 2 == 0) {
                Glide.with(itemView.context).load(firstImg).into(image)
            } else {
                Glide.with(itemView.context).load(secondImg).into(image)
            }
        }
    }
}



