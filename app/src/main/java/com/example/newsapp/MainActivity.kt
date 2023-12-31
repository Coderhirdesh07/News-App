package com.example.newsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.newsapp.architecture.NewsRepository
import com.example.newsapp.architecture.NewsViewModel
import com.example.newsapp.architecture.NewsViewModelProviderFactory
import com.example.newsapp.database.NewsDatabase
import com.example.newsapp.databinding.ActivityMainBinding


import com.example.newsapp.networkutils.NewsData

import com.example.newsapp.recyclerview.NewsAdapter
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

import com.example.newsapp.networkutils.RetrofitInstance.mNewApiService
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.coroutines.Dispatchers
import retrofit2.Call
import retrofit2.Response


 class MainActivity : AppCompatActivity() {
     private  lateinit var recyclerView:RecyclerView
     private lateinit var myAdapter:NewsAdapter
     private val mCityName:String = "in"
     lateinit var viewModel: NewsViewModel
     private lateinit var bottomNav:BottomNavigationView
     private lateinit var binding:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
//        val repository = NewsRepository(NewsDatabase)

        val newsNavHostFragment = findNavController(R.navigation.news_nav_graph)
        bottomNav.setupWithNavController(newsNavHostFragment)


//        val viewModelFactory = NewsViewModelProviderFactory(repository)
//
//        viewModel = ViewModelProvider(this,viewModelFactory).get(NewsViewModel::class.java)


    }


}


