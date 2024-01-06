package com.example.newsapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.newsapp.R
import com.example.newsapp.databinding.ItemNewsBinding
import com.example.newsapp.models.Article

class NewsAdapter : RecyclerView.Adapter<NewsAdapter.NewsViewHolder>() {

    private var onItemClickListener: ((Article) -> Unit)? = null

    class NewsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val binding = ItemNewsBinding.bind(itemView)
        val title: TextView = binding.articleTitle
        val description: TextView = binding.articleDescription
        val source: TextView = binding.articleSource
        val image: ImageView = binding.articleImage
        val dateTime: TextView = binding.articleDateTime

    }

    private val diffUtilCallBack = object : DiffUtil.ItemCallback<Article>() {
        override fun areItemsTheSame(oldItem: Article, newItem: Article): Boolean {
            return oldItem.url == newItem.url
        }

        override fun areContentsTheSame(oldItem: Article, newItem: Article): Boolean {
            return oldItem == newItem
        }

    }

    val diffUtil = AsyncListDiffer(this, diffUtilCallBack)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_news, parent, false)
        return NewsViewHolder(view)
    }

    override fun getItemCount(): Int {
        return diffUtil.currentList.size
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        val article = diffUtil.currentList[position]

//        holder.apply {
//            title.text = article.title
//            description.text = article.description
//            source.text = article.source.name
//            dateTime.text = article.publishedAt
//
//            Glide.with(itemView.context)
//                .load(article.urlToImage)
//                .into(image)
//        }

        holder.apply {
            holder.itemView.apply {

                title.text = article.title
                description.text = article.description
                source.text = article.source.name
                dateTime.text = article.publishedAt

                Glide.with(itemView.context)
                    .load(article.urlToImage)
                    .into(image)

                setOnClickListener {
                    onItemClickListener?.let {
                        it(article)
                    }
                }
            }
        }
    }

    fun setOnItemClickListener(listener: (Article) -> Unit) {
        onItemClickListener = listener
    }

    override fun hashCode(): Int {
        return diffUtil.currentList.hashCode()
    }
}