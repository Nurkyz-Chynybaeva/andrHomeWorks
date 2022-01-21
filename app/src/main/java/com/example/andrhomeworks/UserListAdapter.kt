package com.example.andrhomeworks

import android.content.Context

import android.widget.TextView

import androidx.recyclerview.widget.RecyclerView

import androidx.annotation.NonNull

import android.view.LayoutInflater
import android.view.View

import android.view.ViewGroup
import com.example.andrhomeworks.database.Employee


class UserListAdapter(context: Context) : RecyclerView.Adapter<UserListAdapter.MyViewHolder>() {
    private val context: Context = context
    private var userList: List<Employee>? = null
    fun setUserList(userList: List<Employee>?) {
        this.userList = userList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view: View = LayoutInflater.from(context).inflate(R.layout.recycler_row, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.tvFirstName.setText(userList!![position].name)
        holder.tvLastName.setText(userList!![position].company)
    }

    override fun getItemCount(): Int {
        return userList!!.size
    }

    inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var tvFirstName: TextView
        var tvLastName: TextView

        init {
            tvFirstName = view.findViewById(R.id.tvFirstName)
            tvLastName = view.findViewById(R.id.tvLastName)
        }
    }

}