package com.example.remote.model

data class BookResponseNetwork(
    val uid: String = "",
    val name: String? = "",
    val price: String? = "",
    val created_at: String? = "",
    val image_urls_thumbnails: List<String>? = ArrayList(),
)
