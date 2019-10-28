package com.example.firstapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_relative.*
import java.util.*

class RelativeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_relative)
        bSubmit.setOnClickListener(button)
        bClear.setOnClickListener(buttonshort)


//        bClear.setOnClickListener {
//            fName.text.clear()
//            lName.text.clear()
//        }
//        bSubmit.setOnClickListener {
//            showName.text = fName.text
//            showLast.text = lName.text
//            fName.text.clear()
//            lName.text.clear()
//        }

    }

    private val button: View.OnClickListener = object : View.OnClickListener {
        override fun onClick(view: View?) {
            if (view == bClear) {
                fName.text.clear()
                lName.text.clear()

            } else if (view == bSubmit) {
                showName.text = fName.text
                showLast.text = lName.text
                fName.text.clear()
                lName.text.clear()
            }
        }
    }

    fun onClaer (){
        fName.text.clear()
        lName.text.clear()
    }

    fun onSubmit (){
        showName.text = fName.text
        showLast.text = lName.text
    }

    private val buttonshort = View.OnClickListener { view ->
        when (view) {
            bClear -> {
                onClaer()

            }
            bSubmit -> {
                onSubmit()
                onClaer()
            }
        }
    }
}