package com.example.data.repository

import com.example.data.model.BookDTO


/**
 * Methods of Remote Data Source
 */
interface RemoteDataSource {
    suspend fun getBooks() : List<BookDTO>


}