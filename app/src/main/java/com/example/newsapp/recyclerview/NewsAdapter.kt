package com.example.newsapp.recyclerview

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil

import androidx.recyclerview.widget.RecyclerView
import com.example.newsapp.R
import com.example.newsapp.networkutils.Article


import com.squareup.picasso.Picasso


class NewsAdapter:RecyclerView.Adapter<NewsAdapter.NewsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.news_list_item,parent,false)
        return NewsViewHolder(view)

    }

    override fun getItemCount(): Int {
         return differ.currentList.size
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
       val currentItem = differ.currentList[position]
        holder.mTitle.text = currentItem.title
        holder.mPublishedAt.text = currentItem.publishedAt
        holder.mDescription.text = currentItem.description
        holder.mSource.text = currentItem.source.name
        Picasso.get().load(currentItem.urlToImage).into(holder.mImage)
    }
    private val differCallback = object : DiffUtil.ItemCallback<Article>() {
        override fun areItemsTheSame(oldItem: Article, newItem: Article): Boolean {
            return oldItem.url == newItem.url
        }

        override fun areContentsTheSame(oldItem: Article, newItem: Article): Boolean {
            return oldItem == newItem
        }
    }
    val differ = AsyncListDiffer(this, differCallback)

    private var onItemClickListener: ((Article) -> Unit)? = null

    inner class NewsViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        val mTitle:TextView = itemView.findViewById(R.id.tvTitle)
        val mImage : ImageView = itemView.findViewById(R.id.ivArticleImage)
        val mDescription :TextView = itemView.findViewById(R.id.tvDescription)
        val mPublishedAt :TextView = itemView.findViewById(R.id.tvPublishedAt)
        val mSource :TextView = itemView.findViewById(R.id.tvSource)

    }
    fun setOnItemClickListener(listener:(Article) -> Unit) {
        onItemClickListener = listener

    }
}