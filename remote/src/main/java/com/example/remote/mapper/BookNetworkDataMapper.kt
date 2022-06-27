package com.example.remote.mapper

import com.example.common.Mapper
import com.example.data.model.BookDTO
import com.example.remote.model.BookResponseNetwork
import javax.inject.Inject


class BookNetworkDataMapper @Inject constructor() :
    Mapper<BookResponseNetwork, BookDTO> {

    override fun from(i: BookResponseNetwork?): BookDTO {
        return BookDTO(
            uid = i?.uid ?: "",
            name = i?.name ?: "",
            price = i?.price ?: "",
            created_at = i?.created_at ?: "",
            image_urls_thumbnails = i?.image_urls_thumbnails ?: ArrayList(),
        )
    }

    override fun to(o: BookDTO?): BookResponseNetwork {
        return BookResponseNetwork()
    }
}