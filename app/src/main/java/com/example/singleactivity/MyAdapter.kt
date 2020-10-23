package com.example.singleactivity

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyAdapter: RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    private val items = mutableListOf(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15)

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textNum: TextView = itemView.findViewById(R.id.textNum)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item,parent,false))
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.textNum.text = items[position].toString()
    }

    override fun getItemCount(): Int {
        return items.size
    }
}