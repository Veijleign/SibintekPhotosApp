package com.example.sibintektestapp.retrofit.common

import com.example.sibintektestapp.retrofit.MainApi
import com.example.sibintektestapp.retrofit.RetrofitClient

object Common {

    private val BASE_URL = "https://api.unsplash.com/"

    val retrofitService: MainApi
        get() = RetrofitClient.getClient(BASE_URL).create(MainApi::class.java)
}