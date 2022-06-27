package com.example.domain.repository

import com.example.common.Resource
import com.example.domain.entity.BookEntity
import kotlinx.coroutines.flow.Flow

/**
 * Methods of Repository
 */
interface Repository {
    suspend fun getBooks() : Flow<Resource<List<BookEntity>>>

}