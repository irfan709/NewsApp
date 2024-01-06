package com.example.newsapp.api

import com.example.newsapp.models.NewsModel
import com.example.newsapp.utils.Constants.Companion.API_KEY
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {

    @GET("top-headlines")
    suspend fun getHeadlines(

        @Query("country")
        countryCode: String = "in",

        @Query("page")
        pageNumber: Int = 1,

        @Query("apikey")
        apiKey: String = API_KEY

    ): Response<NewsModel>

    @GET("everything")
    suspend fun searchNews(

        @Query("q")
        searchQuery: String,

        @Query("page")
        pageNumber: Int = 1,

        @Query("apikey")
        apiKey: String = API_KEY

    ): Response<NewsModel>

}