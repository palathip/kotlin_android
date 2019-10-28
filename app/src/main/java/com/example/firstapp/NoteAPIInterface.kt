package com.example.firstapp

import com.google.gson.JsonObject
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface NoteAPIInterface {

    @POST("getlistnote")
    fun getNote(@Body user: JsonObject): Call<Notedao>

    @POST("getsticker")
    fun getSticker(@Body user: JsonObject): Call<List<NoteModel>>
}
