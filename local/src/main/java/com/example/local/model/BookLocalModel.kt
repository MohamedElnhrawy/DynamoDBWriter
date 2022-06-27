package com.example.local.model

import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "book")
data class BookLocalModel(
    @PrimaryKey
    val uid: String,
    val name: String,
    val price: String,
    val created_at: String,
    val image_urls_thumbnails: List<String>,
)