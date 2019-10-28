package com.example.firstapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.ActionBar
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_chat.*
import kotlinx.android.synthetic.main.studen_layout.*

class ChatActivity : AppCompatActivity() {
    lateinit var listChat : ArrayList<MessageModel>
    var MessageAdapter : MessageAdapter? = null
    var MessageModel : MessageModel? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chat)

        val actionBar : ActionBar? = supportActionBar
        actionBar?.title = "Chat Room"
        initComponent()
    }
fun initComponent (){
    listChat = ArrayList()
    MessageModel = TextMessageModel().apply {
        mPropic = resources.getDrawable(R.drawable.user_yellow)
        mMessage = "Test Messages"
        mTime = "11:55"
        mType = 0x0001
        listChat.add(this)
    }
    PictureMessageModel().apply {
        mPropic = resources.getDrawable(R.drawable.user_yellow)
        mPicture = resources.getDrawable(R.drawable.wall)
        mTime = "11:56"
        mType = 0x0001
        listChat.add(this)
    }
    TextMessageModel().apply {
        mPropic = resources.getDrawable(R.drawable.user_blue)
        mMessage = "Test Messages"
        mTime = "11:56"
        mType = 0x0002
        listChat.add(this)
    }
    PictureMessageModel().apply {
        mPropic = resources.getDrawable(R.drawable.user_blue)
        mPicture = resources.getDrawable(R.drawable.wall)
        mTime = "11:56"
        mType = 0x0002
        listChat.add(this)
    }
    TextMessageModel().apply {
        mPropic = resources.getDrawable(R.drawable.user_blue)
        mMessage = "Test Messages"
        mTime = "11:56"
        mType = 0x0002
        listChat.add(this)
    }
    TextMessageModel().apply {
        mPropic = resources.getDrawable(R.drawable.user_blue)
        mMessage = "Test Messages"
        mTime = "11:56"
        mType = 0x0002
        listChat.add(this)
    }
    MessageAdapter = MessageAdapter(this,listChat)
    MessageAdapter?.notifyDataSetChanged()
    chatView.adapter = MessageAdapter
    chatView.layoutManager = LinearLayoutManager(this)
}
}

