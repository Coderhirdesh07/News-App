package com.example.newsapp.architecture


import com.example.newsapp.database.NewsDatabase
import com.example.newsapp.networkutils.RetrofitInstance
import com.example.newsapp.Const.Companion.Api_Key
import com.example.newsapp.networkutils.Article

class NewsRepository(val db:NewsDatabase) {


    suspend fun getBreakingNews(countryCode:String,pageNumber:Int){
        RetrofitInstance.mNewApiService.getNewsTopHeadlines(countryCode,pageNumber, Api_Key)
    }

//    suspend fun getSearchNews(countryCode: String,pageNumber: Int){
//        RetrofitInstance.mNewApiService
//    }

    suspend fun insert(article: Article) = db.getArticleDao().insertArticle(article)

    suspend fun delete(article: Article)=db.getArticleDao().deleteArticle(article)

   fun getAllArticles()=db.getArticleDao().getListOfAllArticle()




}