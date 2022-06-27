package com.example.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverter
import androidx.room.TypeConverters
import com.example.local.converter.Converters
import com.example.local.model.BookLocalModel

@Database(entities = [BookLocalModel::class], version = 1, exportSchema = false) // We need migration if increase version
@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun bookDao() : BookDAO
}