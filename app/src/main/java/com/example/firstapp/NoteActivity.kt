package com.example.firstapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.gson.JsonObject
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.POST as POST1

class NoteActivity : AppCompatActivity() {
    private var noteApiInterface: NoteAPIInterface? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_note)

        noteApiInterface = getClient()?.create(NoteAPIInterface::class.java)

        val jsonObject = JsonObject()
        jsonObject.addProperty("tokenroom", "R5b4599b85eb92700280f496cf721f0f25e605febb4a8df83e89c7cfb")
        jsonObject

        val call = noteApiInterface?.getNote(jsonObject)
        call?.enqueue(object : Callback<Notedao>{
            override fun onResponse(call: Call<Notedao>, response: Response<Notedao>) {
                val note = response.body()

                if (note?.list_note != null && note.list_note?.size != 0){
//                    Log.e("API---",)
                }
            }

            override fun onFailure(call: Call<Notedao>, t: Throwable) {
                call.cancel()
            }
        })
    }

    private fun getClient(): Retrofit? {
        val retrofit = Retrofit.Builder()
            .baseUrl("http://203.151.50.18:8997/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        return retrofit

    }
}