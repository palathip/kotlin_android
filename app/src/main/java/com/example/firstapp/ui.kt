package com.example.firstapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBar
import kotlinx.android.synthetic.main.activity_ui.*

class ui : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ui)

        setSupportActionBar(toolBar)

        val actionBar : ActionBar? = supportActionBar
        actionBar?.title = "Settings"
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.item_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item?.itemId){
            R.id.action_more -> {
                Toast.makeText(this,"Jub Jub",Toast.LENGTH_LONG).show()
            }
            R.id.act1 -> {
                Toast.makeText(this,"Ei Ei",Toast.LENGTH_LONG).show()
            }
            R.id.act2 -> {
                Toast.makeText(this,"Eu Eu",Toast.LENGTH_LONG).show()
            }
        }
        return super.onOptionsItemSelected(item)
    }
}
