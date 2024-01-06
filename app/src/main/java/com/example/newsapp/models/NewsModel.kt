package com.example.newsapp.models

data class NewsModel(
    val articles:MutableList<Article>,
    val status: String,
    val totalResults: Int
)