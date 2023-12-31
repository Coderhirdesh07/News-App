package com.example.newsapp

import com.example.newsapp.networkutils.NewsData

sealed class Resource<T>(
    val response:T?=null,
    val error:String?=null
) {

    class Success<T>(data:T): Resource<T>(data)

    class Error<T>(error: String,data:T?=null): Resource<T>(data,error)

    class Loading<T>(): Resource<T>()
}