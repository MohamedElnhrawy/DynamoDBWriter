package com.example.domain.entity


data class BookEntity(
    val uid: String,
    val name: String,
    val price: String,
    val created_at: String,
    val image_urls_thumbnails: List<String>,

)