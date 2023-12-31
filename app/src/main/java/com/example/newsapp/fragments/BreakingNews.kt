package com.example.newsapp.fragments

import android.os.Bundle
import android.view.View
import android.widget.Adapter
import android.widget.ProgressBar
import androidx.fragment.app.Fragment
import com.example.newsapp.MainActivity
import com.example.newsapp.R
import com.example.newsapp.architecture.NewsViewModel
import com.example.newsapp.recyclerview.NewsAdapter


class BreakingNews : Fragment(R.layout.fragment_breaking_news) {
    private lateinit var viewModel: NewsViewModel
    private lateinit var paginationProgressBar:ProgressBar
    private lateinit var  myNewsAdapter:NewsAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = (activity as MainActivity).viewModel

        setupRecyclerView()
    }

    private fun showProgressBar(){
      paginationProgressBar.visibility = View.VISIBLE
    }
    private fun hideProgressBar(){
        paginationProgressBar.visibility = View.INVISIBLE
    }
    private fun setupRecyclerView(){



    }



}