package com.example.newsapp.networkutils

data class NewsData(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)