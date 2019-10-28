package com.example.firstapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_recleview.*

class Recleview : AppCompatActivity() {

    lateinit var mlist: ArrayList<String>
    var mAdapter: ConfigMenuAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recleview)
        initComponent()
    }

    fun initComponent () {
        mlist = ArrayList()
        mlist.add("boombibu")
        mlist.add("palathip")
        mAdapter = ConfigMenuAdapter(this,mlist)
        mAdapter?.notifyDataSetChanged()

        re_View.adapter = mAdapter
        re_View.layoutManager = LinearLayoutManager(this)

    }

}
