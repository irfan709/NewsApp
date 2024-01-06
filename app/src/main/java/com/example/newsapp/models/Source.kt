package com.example.newsapp.models

data class Source(
    val id: String,
    val name: String
)  {
    override fun hashCode(): Int {
        return id.hashCode()
    }
}