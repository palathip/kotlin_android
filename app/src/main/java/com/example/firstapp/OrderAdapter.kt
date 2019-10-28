package com.example.firstapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.firstapp.OrderAdapter.Companion.Type_1
import com.example.firstapp.OrderAdapter.Companion.Type_2
import kotlinx.android.synthetic.main.order_layout.view.*
import kotlinx.android.synthetic.main.rowlist.view.*
import kotlinx.android.synthetic.main.studen_layout.view.*
import java.lang.reflect.Type

class OrderAdapter(val context : Context? , val list: ArrayList<OrderModel>) : RecyclerView.Adapter <RecyclerView.ViewHolder> () {


    companion object {
        val Type_1: Int = 1
        val Type_2: Int = 2
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        if (viewType == Type_1) {
            val viewHolder =
                LayoutInflater.from(context).inflate(R.layout.order_layout, parent, false)
            return OrderViewHoleder(viewHolder)
        } else {
            val viewHolder =
                LayoutInflater.from(context).inflate(R.layout.reorder_layout, parent, false)
            return OrderViewHoleder2(viewHolder)
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

    interface Listener {
        fun onClickItem(item: OrderModel, position: Int)
    }

    var listener: Listener? = null

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        var order = list[position]
        if (holder is OrderViewHoleder) {
            holder.ivPic.setImageDrawable(order.mPic)
            holder.itOrder.text = order.mOder
            holder.itBuyer.text = order.mBuyer
            holder.itDate.text = order.mDate
            holder.itPrice.text = order.mPrice

            holder.itemView.setOnClickListener {
                listener?.onClickItem(order, position)
            }
        }
        else if(holder is OrderViewHoleder2){
            holder.ivPic.setImageDrawable(order.mPic)
            holder.itOrder.text = order.mOder
            holder.itBuyer.text = order.mBuyer
            holder.itDate.text = order.mDate
            holder.itPrice.text = order.mPrice

            holder.itemView.setOnClickListener {
                listener?.onClickItem(order, position)
            }
//
        }

    }

    override fun getItemViewType(position: Int): Int {
        if (position % 2 == 0) {
            return Type_1
        } else {
            return Type_2
        }
    }

    inner class OrderViewHoleder(view: View) : RecyclerView.ViewHolder(view) {
        var ivPic = view.orderPic
        var itOrder = view.orderId
        var itBuyer = view.orderName
        var itDate = view.orderDate
        var itPrice = view.orderPrice
    }

    inner class OrderViewHoleder2(view: View) : RecyclerView.ViewHolder(view) {
        var ivPic = view.orderPic
        var itOrder = view.orderId
        var itBuyer = view.orderName
        var itDate = view.orderDate
        var itPrice = view.orderPrice
    }
}