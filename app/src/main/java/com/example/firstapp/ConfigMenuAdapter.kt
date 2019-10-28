package com.example.firstapp

import android.content.Context
import android.os.Parcel
import android.os.Parcelable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.rowlist.view.*

class ConfigMenuAdapter(val context : Context, val list: ArrayList<String>) : RecyclerView.Adapter<ConfigMenuAdapter.ViewHoleder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ConfigMenuAdapter.ViewHoleder {
        val viewHolder = LayoutInflater.from(context).inflate(R.layout.rowlist, parent, false)
        return ViewHoleder(viewHolder)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ConfigMenuAdapter.ViewHoleder, position: Int) {
        var name:String = list[position]
        holder.tvvName.text = name
    }
    inner class ViewHoleder(view : View)  : RecyclerView.ViewHolder(view) {
        var tvvName = view.tvName
    }
}