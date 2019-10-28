package com.example.firstapp

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_order_one.*


class OrderOneFragment : Fragment() , OrderAdapter.Listener{
    override fun onClickItem(item: OrderModel, position: Int) {
        toOrderDatail(item,position)
    }

    lateinit var mOrderList: ArrayList<OrderModel>
    var orderAdapter: OrderAdapter? = null
    var orderModel: OrderModel? = null
    var REQUEST_UPDATE = 200

    companion object {
        fun init(): OrderOneFragment {
            val fragment = OrderOneFragment()
            return fragment
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_order_one,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var i = 1
        mOrderList = ArrayList()
        while (i < 10) {
            orderModel = OrderModel().apply {
                mPic = resources.getDrawable(R.drawable.image3)
                mBuyer = "นายสมพง ใจดี"
                mDate = "16 มิ.ย. 2562"
                mOder = String.format("%03d", i)
                mPrice = "12000 บาท"
                mOrderList.add(this)
            }
            i++
        }

        orderAdapter = OrderAdapter(activity, mOrderList)
        orderAdapter?.listener = this
        orderAdapter?.notifyDataSetChanged()
        orderView.adapter = orderAdapter
        orderView.layoutManager = LinearLayoutManager(activity)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (resultCode == Activity.RESULT_OK){
            if (requestCode == REQUEST_UPDATE){

                val position = data?.getIntExtra("position",100)
                val orderID = data?.getStringExtra("order")
                val orderBuyer = data?.getStringExtra("buyer")

                position?.let { manageOrder(it, orderID, orderBuyer)}

            }
        }
    }

    fun manageOrder(position: Int, orderID: String?, orderBuyer: String?){
        if (position < mOrderList.size){
            mOrderList[position].mOder = orderID
            mOrderList[position].mBuyer = orderBuyer

            orderAdapter?.notifyItemChanged(position)
        }
    }


    fun toOrderDatail(model: OrderModel,position: Int){
        val intent = Intent(activity,OrderUpdate::class.java)
        intent.putExtra("position",position)
        intent.putExtra("order",model.mOder)
        intent.putExtra("buyer",model.mBuyer)
        startActivityForResult(intent,REQUEST_UPDATE)
    }


}

