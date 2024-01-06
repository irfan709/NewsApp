package com.example.newsapp.repository

import com.example.newsapp.api.ApiUtils
import com.example.newsapp.database.ArticleDatabase
import com.example.newsapp.models.Article

class NewsRepository(val database: ArticleDatabase) {

    suspend fun getHeadLines(countryCode: String, pageNumber: Int) =
        ApiUtils.api.getHeadlines(countryCode, pageNumber)

    suspend fun searchNews(searchQuery: String, pageNumber: Int) =
        ApiUtils.api.searchNews(searchQuery, pageNumber)

    suspend fun insertNews(article: Article) = database.getArticlesDao().insertNews(article)

    fun getFavouriteNews() = database.getArticlesDao().getAllArticles()

    suspend fun deleteArticle(article: Article) = database.getArticlesDao().deleteArticles(article)

}