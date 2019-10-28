package com.example.firstapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_order_detail.*

class OrderDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order_detail)

        val ordername = intent.getStringExtra("NAME")
        tvOrder.text = ordername

        btnClose.setOnClickListener{
            finish()
        }
    }
}
