package com.example.newsapp.networkutils


import com.example.newsapp.Const.Companion.Api_Key
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query



interface NewsApi {

     @GET("top-headlines")
      suspend fun getNewsTopHeadlines(
         @Query("country") countryCode:String="us",
         @Query("page") pageNumber:Int=1,
         @Query("apiKey") apiKey:String=Api_Key
      ): Response<NewsData>

    @GET("top-headlines")
     suspend fun getSearchNewsTopHeadlines(
         @Query("q") searchResult:String,
         @Query("page") pageNumber: Int=1,
         @Query("apiKey") apiKey: String = Api_Key
     ):Response<NewsData>

}