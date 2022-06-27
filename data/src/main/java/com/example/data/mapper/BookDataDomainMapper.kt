package com.example.data.mapper

import com.example.common.Mapper
import com.example.data.model.BookDTO
import com.example.domain.entity.BookEntity
import javax.inject.Inject


class BookDataDomainMapper @Inject constructor() :
    Mapper<BookDTO, BookEntity> {

    override fun from(i: BookDTO?): BookEntity {
        return BookEntity(
            uid = i?.uid ?: "",
            name = i?.name ?: "",
            price = i?.price ?: "",
            created_at = i?.created_at ?: "",
            image_urls_thumbnails = i?.image_urls_thumbnails ?: ArrayList(),

        )
    }


    override fun to(o: BookEntity?): BookDTO {
        return BookDTO(
            uid = o?.uid ?: "",
            name = o?.name ?: "",
            price = o?.price ?: "",
            created_at = o?.created_at ?: "",
            image_urls_thumbnails = o?.image_urls_thumbnails ?: ArrayList(),

        )
    }
}