package com.example.newsapp.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy.Companion.REPLACE
import androidx.room.Query
import com.example.newsapp.networkutils.Article

@Dao
interface NewsDao {

     @Insert(onConflict = REPLACE)
     suspend fun insertArticle(article: Article): Long

     @Query("Select * from article")
     fun getListOfAllArticle():LiveData<List<Article>>

     @Delete
     suspend fun deleteArticle(article: Article)
}