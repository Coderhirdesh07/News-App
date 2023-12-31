package com.example.newsapp.architecture

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.newsapp.Resource
import com.example.newsapp.networkutils.Article
import com.example.newsapp.networkutils.NewsData
import kotlinx.coroutines.launch
import retrofit2.Response

class NewsViewModel(private val newsRepository: NewsRepository):ViewModel() {

    private val breakingNews:MutableLiveData<Resource<NewsData>> = MutableLiveData()
    private var breakingNewsPage = 1


    fun getBreakingNews(countryCode:String)=viewModelScope.launch {
        breakingNews.postValue(Resource.Loading())
        val response = newsRepository.getBreakingNews(countryCode,breakingNewsPage)
    }

    private fun handleBreakingNewsResponse(response: Response<NewsData>):Resource<NewsData>{
        if(response.isSuccessful){
            response.body()?.let { resultResponse  ->
                return Resource.Success(resultResponse)
            }
        }
        return Resource.Error(response.message())
    }

    fun saveArticles(article: Article)=viewModelScope.launch {
        newsRepository.insert(article)
    }

    fun deleteArticles(article: Article)=viewModelScope.launch {
        newsRepository.delete(article)
    }

    fun getArticles() = newsRepository.getAllArticles()



}