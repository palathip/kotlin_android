package com.example.firstapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.firstapp.OrderAdapter.Companion.Type_1
import com.example.firstapp.OrderAdapter.Companion.Type_2
import kotlinx.android.synthetic.main.left_message_layout.view.*
import kotlinx.android.synthetic.main.left_message_layout.view.proPic
import kotlinx.android.synthetic.main.left_message_layout.view.textTime
import kotlinx.android.synthetic.main.left_picture_layout.view.*
import kotlinx.android.synthetic.main.order_layout.view.*
import kotlinx.android.synthetic.main.rowlist.view.*
import kotlinx.android.synthetic.main.studen_layout.view.*
import java.lang.reflect.Type

class MessageAdapter(val context : Context? , val list: ArrayList<MessageModel>) : RecyclerView.Adapter <RecyclerView.ViewHolder> () {


    companion object {
        val typeLeft : Int = 0x0001
        val typeRight : Int = 0x0002
        val leftText : Int = 1
        val leftPic : Int = 2
        val rightText : Int = 3
        val rightPic : Int = 4
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        if (viewType == leftText) {
            val viewHolder = LayoutInflater.from(context).inflate(R.layout.left_message_layout, parent, false)
            return LeftMessageView(viewHolder)

        } else if (viewType == leftPic) {
            val viewHolder = LayoutInflater.from(context).inflate(R.layout.left_picture_layout, parent, false)
            return LeftPictureView(viewHolder)

        } else if (viewType == rightText) {
            val viewHolder = LayoutInflater.from(context).inflate(R.layout.right_message_layout, parent, false)
            return RightMessageView(viewHolder)

        } else {
            val viewHolder = LayoutInflater.from(context).inflate(R.layout.right_picture_layout, parent, false)
            return RightPictureView(viewHolder)
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }



    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        var model = list[position]
        if (holder is LeftMessageView) {
            if (model is TextMessageModel) {
                holder.ivProPic.setImageDrawable(model.mPropic)
                holder.itText.text = (model.mMessage)
                holder.itTime.text = (model.mTime)
            }
        }
        else if (holder is LeftPictureView){
            if (model is PictureMessageModel){
            holder.ivProPic.setImageDrawable(model.mPropic)
            holder.ivPicture.setImageDrawable(model.mPicture)
            holder.itTime.text = (model.mTime)
        }
        }
        else if (holder is RightMessageView) {
            if (model is TextMessageModel) {
                holder.itTime.text = (model.mTime)
                holder.itText.text = (model.mMessage)
                holder.ivProPic.setImageDrawable(model.mPropic)
            }
        }
        else if (holder is RightPictureView){
          if(model is PictureMessageModel) {
              holder.itTime.text = (model.mTime)
              holder.ivPicture.setImageDrawable(model.mPicture)
              holder.ivProPic.setImageDrawable(model.mPropic)
          }
          }
    }

    override fun getItemViewType(position: Int): Int {
        var type = list[position].mType
        if(type == typeLeft){
            if (list.get(position) is TextMessageModel){
                return leftText
            }
            else{
                return leftPic
            }
        }
        else {
            if (list.get(position) is TextMessageModel) {
                return rightText
            } else {
                return rightPic
            }
        }
    }

    inner class LeftMessageView(view: View) : RecyclerView.ViewHolder(view) {
        var ivProPic = view.proPic
        var itText = view.textMessage
        var itTime = view.textTime
    }

    inner class LeftPictureView(view: View) : RecyclerView.ViewHolder(view) {
        var ivProPic = view.proPic
        var ivPicture = view.picMessage
        var itTime = view.textTime
    }

    inner class RightMessageView(view: View) : RecyclerView.ViewHolder(view) {
        var ivProPic = view.proPic
        var itText = view.textMessage
        var itTime = view.textTime
    }

    inner class RightPictureView(view: View) : RecyclerView.ViewHolder(view) {
        var ivProPic = view.proPic
        var ivPicture = view.picMessage
        var itTime = view.textTime
    }
}