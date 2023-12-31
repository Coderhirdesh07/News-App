package com.example.newsapp.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.newsapp.networkutils.Article


@Database(
    entities = [Article::class],
    version = 1)

 @TypeConverters(Converters::class)

abstract class NewsDatabase :RoomDatabase() {
    abstract fun getArticleDao(): NewsDao

    companion object {
        @Volatile
        private var instance: NewsDatabase? = null
        private var Lock = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(Lock) {
            instance ?: createDatabase(context).also { instance = it }
        }

        private fun createDatabase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                NewsDatabase::class.java,
                "article"
            ).build()
    }
}




