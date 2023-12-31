package com.example.newsapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.navigation.NavArgs

import com.example.newsapp.MainActivity
import com.example.newsapp.R
import com.example.newsapp.architecture.NewsViewModel

import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.floatingactionbutton.FloatingActionButton


class ArticleFragment : Fragment(R.layout.fragment_article) {
    private lateinit var viewModel: NewsViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = (activity as MainActivity).viewModel
//        val articleFragment = bottomNav.findViewById<FloatingActionButton>(R.layout.fragment_article)
//        articleFragment.setOnClickListener{
//            viewModel.saveArticles(articles)
//        }


    }
}