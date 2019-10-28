package com.example.firstapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_student.*

class StudentActivity : AppCompatActivity() {

    lateinit var mStudentList : ArrayList<StudentModel>
    var sAdapter : StudentAdapter? = null
    var studentModel : StudentModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_student)
        initComponent()
    }
    fun initComponent (){

        mStudentList = ArrayList()
         studentModel = StudentModel().apply {
            mName = "Palathip"
            mProfile = resources.getDrawable(R.drawable.blocked)
             mStudentList.add(this)
        }
        StudentModel().apply {
            mName = "Boombibu"
            mProfile = resources.getDrawable(R.drawable.blocked)
            mStudentList.add(this)
        }
        StudentModel().apply {
            mName = "Boombibu"
            mProfile = resources.getDrawable(R.drawable.blocked)
            mStudentList.add(this)
        }

//        การเขียนอีกแบบนึง
//        studentModel = StudentModel ()
//        studentModel?.mName = "Boombibu"
//        studentModel?.mProfile = resources.getDrawable(R.drawable.blocked)

//        add list
//        studentModel?.let {
//            mStudentList
//        }


        sAdapter = StudentAdapter(this, mStudentList)
        sAdapter?.notifyDataSetChanged()
        studentView.adapter =  sAdapter
        studentView.layoutManager = LinearLayoutManager(this)
    }
}
