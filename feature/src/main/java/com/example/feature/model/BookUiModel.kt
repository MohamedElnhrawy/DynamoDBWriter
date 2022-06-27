package com.example.feature.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
data class BookUiModel(
    val uid: String,
    val name: String,
    val price: String,
    val created_at: String,
    val image_urls_thumbnails: List<String>,

) : Parcelable