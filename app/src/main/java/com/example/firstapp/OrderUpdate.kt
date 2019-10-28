package com.example.firstapp

import android.app.Activity
import android.content.Intent
import android.icu.text.Transliterator
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_order_update.*

class OrderUpdate : AppCompatActivity() {

        var position: Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order_update)

        position = intent.getIntExtra("position",100)

            val orderid = intent.getStringExtra("order")
            val orderbayer = intent.getStringExtra("buyer")

        edtOrderID.setText(orderid)
        edtName.setText(orderbayer)
        initComponent()

    }
    fun initComponent () {
        btnUpdate.setOnClickListener{
            val OrderId = edtOrderID.text.toString()
            val OrderBuyer = edtName.text.toString()

//            val intent = Intent(this,OrderActivity::class.java)
            val intent = intent
            intent.putExtra("position",position)
            intent.putExtra("order", OrderId)
            intent.putExtra("buyer",OrderBuyer)
            setResult(Activity.RESULT_OK,intent)
            finish()
        }

    }

}
