package com.example.local.database

import androidx.room.*
import com.example.local.model.BookLocalModel

@Dao
interface BookDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addBookItem(book : BookLocalModel) : Long

    @Query("SELECT * FROM book WHERE uid = :id")
    suspend fun getBookItem(id: String): BookLocalModel

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addBookItems(book: List<BookLocalModel>) : List<Long>

    @Query("SELECT * FROM book")
    suspend fun getBookItems(): List<BookLocalModel>

    @Update
    suspend fun updateBookItem(book: BookLocalModel): Int

    @Query("DELETE FROM book WHERE uid = :id")
    suspend fun deleteBookItemById(id : String) : Int

    @Delete
    suspend fun deleteBookItem(book : BookLocalModel) : Int

    @Query("DELETE FROM book")
    suspend fun clearCachedBookItems(): Int
}