package com.example.firstapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.rowlist.view.*
import kotlinx.android.synthetic.main.studen_layout.view.*

class StudentAdapter(val context : Context , val list: ArrayList<StudentModel>) : RecyclerView.Adapter <StudentAdapter.ItemStudentViewHoleder> () {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemStudentViewHoleder {
        val viewHolder = LayoutInflater.from(context).inflate(R.layout.studen_layout, parent, false)
        return ItemStudentViewHoleder(viewHolder)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ItemStudentViewHoleder, position: Int) {
        var student = list[position]
        holder.ivProflie.setImageDrawable(student.mProfile)
        holder.ivName.text = student.mName
    }

    inner class ItemStudentViewHoleder(view : View)  : RecyclerView.ViewHolder(view) {
        var  ivProflie = view.ivProfile
        var ivName = view.ivName
    }
}