package com.example.newsapp.networkutils

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {


private val mRetrofit by lazy {
    Retrofit.Builder()
        .baseUrl("https://newsapi.org/v2/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}

    val mNewApiService:NewsApi by lazy {
        mRetrofit.create(NewsApi::class.java)
    }
}