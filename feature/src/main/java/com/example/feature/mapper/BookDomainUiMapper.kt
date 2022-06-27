package com.example.feature.mapper

import com.example.common.Mapper
import com.example.domain.entity.BookEntity
import com.example.feature.model.BookUiModel
import javax.inject.Inject


class BookDomainUiMapper @Inject constructor() : Mapper<BookEntity, BookUiModel> {


    override fun from(i: BookEntity?): BookUiModel {
        return  BookUiModel(
            uid = i?.uid?:"",
            name = i?.name?:"",
            price = i?.price ?: "",
            created_at = i?.created_at ?: "",
            image_urls_thumbnails = i?.image_urls_thumbnails ?: ArrayList(),
        )
    }

    override fun to(o: BookUiModel?): BookEntity {
        return  BookEntity(
            uid = o?.uid?:"",
            name = o?.name?:"",
            price = o?.price ?: "",
            created_at = o?.created_at ?: "",
            image_urls_thumbnails = o?.image_urls_thumbnails ?: ArrayList(),
        )
    }
}