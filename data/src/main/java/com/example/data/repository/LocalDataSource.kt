package com.example.data.repository

import com.example.data.model.BookDTO


/**
 * Methods of Local Data Source
 */
interface LocalDataSource {
    suspend fun addItem(book : BookDTO) : Long

    suspend fun getItem(id: String): BookDTO

    suspend fun addItems(books: List<BookDTO>) : List<Long>

    suspend fun getItems(): List<BookDTO>

    suspend fun updateItem(book: BookDTO): Int

    suspend fun deleteItemById(id : String) : Int

    suspend fun deleteItem(book : BookDTO) : Int

    suspend fun clearCachedItems(): Int
}