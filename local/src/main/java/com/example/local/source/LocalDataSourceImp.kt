package com.example.local.source

import com.example.common.Mapper
import com.example.data.model.BookDTO
import com.example.data.repository.LocalDataSource
import com.example.local.database.BookDAO
import com.example.local.model.BookLocalModel
import javax.inject.Inject

/**
 * Implementation of [LocalDataSource] Source
 */
class LocalDataSourceImp @Inject constructor(
    private val bookDAO: BookDAO,
    private val bookMapper : Mapper<BookLocalModel, BookDTO>
) : LocalDataSource {
    override suspend fun addItem(book: BookDTO): Long {
        val bookLocalModel = bookMapper.to(book)
        return bookDAO.addBookItem(book = bookLocalModel)
    }


    override suspend fun getItem(id: String): BookDTO {
        val bookLocalModel = bookDAO.getBookItem(id = id)
        return bookMapper.from(bookLocalModel)
    }

    override suspend fun addItems(books: List<BookDTO>): List<Long> {
        val bookLocalList = bookMapper.toList(books)
        return bookDAO.addBookItems(book = bookLocalList)
    }

    override suspend fun getItems(): List<BookDTO> {
        val bookLocalList = bookDAO.getBookItems()
        return bookMapper.fromList(bookLocalList)
    }

    override suspend fun updateItem(book: BookDTO): Int {
        val bookLocalModel = bookMapper.to(book)
        return bookDAO.updateBookItem(book = bookLocalModel)
    }

    override suspend fun deleteItemById(id: String): Int {
        return bookDAO.deleteBookItemById(id = id)
    }

    override suspend fun deleteItem(book: BookDTO): Int {
        val bookLocalModel = bookMapper.to(book)
        return bookDAO.deleteBookItem(book = bookLocalModel)    }

    override suspend fun clearCachedItems(): Int {
        return bookDAO.clearCachedBookItems()
    }


}