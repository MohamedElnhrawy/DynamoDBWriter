package com.example.local.mapper

import com.example.common.Mapper
import com.example.data.model.BookDTO
import com.example.local.model.BookLocalModel
import javax.inject.Inject

class BookLocalDataMapper @Inject constructor() : Mapper<BookLocalModel, BookDTO> {

    override fun from(i: BookLocalModel?): BookDTO {
        return BookDTO(
            uid = i?.uid ?: "",
            name = i?.name ?: "",
            price = i?.price ?: "",
            created_at = i?.created_at ?: "",
            image_urls_thumbnails = i?.image_urls_thumbnails ?: ArrayList(),

        )
    }

    override fun to(o: BookDTO?): BookLocalModel {
        return BookLocalModel(
            uid = o?.uid ?: "",
            name = o?.name ?: "",
            price = o?.price ?: "",
            created_at = o?.created_at ?: "",
            image_urls_thumbnails = o?.image_urls_thumbnails ?: ArrayList(),
        )
    }
}