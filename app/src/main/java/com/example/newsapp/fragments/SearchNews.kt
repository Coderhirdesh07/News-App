package com.example.newsapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment

import android.view.View

import com.example.newsapp.MainActivity
import com.example.newsapp.R

import com.example.newsapp.architecture.NewsViewModel


class SearchNews : Fragment(R.layout.fragment_search_news) {
    private lateinit var viewModel: NewsViewModel
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = (activity as MainActivity).viewModel
    }

}

