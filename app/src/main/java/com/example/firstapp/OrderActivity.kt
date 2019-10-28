package com.example.firstapp

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.renderscript.Script
import androidx.appcompat.app.ActionBar
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_order.*
import kotlinx.android.synthetic.main.activity_ui.*
import kotlinx.android.synthetic.main.activity_ui.toolBar

class OrderActivity : AppCompatActivity() , OrderAdapter.Listener{
    override fun onClickItem(item: OrderModel, position: Int) {
        toOrderDatail(item,position)
    }

    var REQUEST_UPDATE = 200

    lateinit var mOrderList: ArrayList<OrderModel>
    var orderAdapter: OrderAdapter? = null
    var orderModel: OrderModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order)

//        setSupportActionBar(toolBar)
        val actionBar: ActionBar? = supportActionBar
        actionBar?.title = "รายการใบสั่งซื้อ"
        actionBar?.setDisplayHomeAsUpEnabled(true)
        initComponent()
//        btnDetail.setOnClickListener {
//            toOrderDatail()
//        }
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
        val intent = Intent(this,OrderUpdate::class.java)
        intent.putExtra("position",position)
        intent.putExtra("order",model.mOder)
        intent.putExtra("buyer",model.mBuyer)
        startActivityForResult(intent,REQUEST_UPDATE)
    }

    fun initComponent() {
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

        orderAdapter = OrderAdapter(this, mOrderList)
        orderAdapter?.listener = this
        orderAdapter?.notifyDataSetChanged()
        orderView.adapter = orderAdapter
        orderView.layoutManager = LinearLayoutManager(this)
    }

    override fun onBackPressed() {
        super.onBackPressed()


    }
}