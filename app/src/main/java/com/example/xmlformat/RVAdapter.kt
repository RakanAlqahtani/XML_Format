package com.example.xmlformat

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.xmlformat.RVAdapter.ItemViewHolder
import kotlinx.android.synthetic.main.items_row.view.*

class RVAdapter(val student:ArrayList<Student>) : RecyclerView.Adapter<RVAdapter.ItemViewHolder>() {
    class ItemViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return ItemViewHolder(LayoutInflater.from(parent.context).inflate(
            R.layout.items_row,
            parent,
            false
        ))
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
       var st = student[position]

        holder.itemView.apply {
            tvName.text = st.name
            tvGrade.text = st.grade.toString()
        }

    }

    override fun getItemCount() = student.size
}