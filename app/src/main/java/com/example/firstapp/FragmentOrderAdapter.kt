package com.example.firstapp

import android.icu.text.CaseMap
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class FragmentOrderAdapter(fragment: FragmentManager) : FragmentPagerAdapter(fragment) {

    var mTitleList: ArrayList<String> = ArrayList()
    var mFragmentList: ArrayList<Fragment> = ArrayList()

    override fun getCount(): Int {
        return mFragmentList.size
    }

    override fun getItem(position: Int): Fragment? {
        return mFragmentList[position]
    }

    fun addFragment(fragment: Fragment, title: String){
        mFragmentList.add(fragment)
        mTitleList.add(title)
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return mTitleList[position]
    }

}