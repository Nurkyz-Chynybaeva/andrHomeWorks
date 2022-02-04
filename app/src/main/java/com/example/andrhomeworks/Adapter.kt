package com.example.andrhomeworks

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import com.example.andrhomeworks.database.Employee
import io.reactivex.Observable

class Adapter(private val click: (item: Employee) -> Unit) :
    RecyclerView.Adapter<Adapter.ViewHolder>() {
    private var list = listOf<Employee>()

    fun setData(list: List<Employee>) {
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

    class ViewHolder(
        itemView: View, private val click: (item: Employee) -> Unit
    ) : RecyclerView.ViewHolder(itemView) {

        fun bind(item: Employee) {
            val txtN = itemView.findViewById<AppCompatTextView>(R.id.itemName)
            val txtC = itemView.findViewById<AppCompatTextView>(R.id.itemCompany)
            val txtS = itemView.findViewById<AppCompatTextView>(R.id.item_salary)

            txtN.text = item.name
            txtC.text = item.company
            txtS.text = item.salary

            itemView.setOnClickListener {
                click.invoke(item)

            }
        }
    }
}