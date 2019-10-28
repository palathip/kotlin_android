package com.example.firstapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main_order.*

class MainOrderActivity : AppCompatActivity() {

    var mFragmentAdapter: FragmentOrderAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_order)
        initComponent()
    }
    fun initComponent(){
        mFragmentAdapter = FragmentOrderAdapter(supportFragmentManager)

        mFragmentAdapter?.addFragment(OrderOneFragment.init(),"1")
        mFragmentAdapter?.addFragment(OrderOneFragment.init(),"2")
        mFragmentAdapter?.addFragment(OrderOneFragment.init(),"3")
        mFragmentAdapter?.addFragment(OrderOneFragment.init(),"4")
        mFragmentAdapter?.addFragment(OrderOneFragment.init(),"5")

        viewPager.adapter = mFragmentAdapter
        tabBar.setupWithViewPager(viewPager)

    }
}
