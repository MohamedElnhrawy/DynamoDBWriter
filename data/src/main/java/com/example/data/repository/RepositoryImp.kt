package com.example.data.repository

import com.example.common.Mapper
import com.example.common.Resource
import com.example.data.model.BookDTO
import com.example.domain.entity.BookEntity
import com.example.domain.repository.Repository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

/**
 * Implementation class of [Repository]
 */
class RepositoryImp @Inject constructor(
    private val localDataSource: LocalDataSource,
    private val remoteDataSource: RemoteDataSource,
    private val bookMapper: Mapper<BookDTO, BookEntity>,
) : Repository {
    override suspend fun getBooks(): Flow<Resource<List<BookEntity>>> {
        return flow {
            try {
                // Get data from RemoteDataSource
                val data = remoteDataSource.getBooks()
                // Save to local or update if exist
                for (book in data) {
                    val localId = localDataSource.getItem(book.uid).uid
                    if (localId == "")
                        localDataSource.addItem(book)
                    else
                        localDataSource.updateItem(book)
                }
                // Emit data
                emit(Resource.Success(bookMapper.fromList(data)))
            } catch (ex: Exception) {
                // If remote request fails
                try {
                    // Get data from LocalDataSource
                    val local = localDataSource.getItems()
                    // Emit data
                    if (local.isNotEmpty())
                        emit(Resource.Success(bookMapper.fromList(local)))
                    else
                        emit(Resource.Error(ex))
                } catch (ex1: Exception) {
                    // Emit error
                    emit(Resource.Error(ex1))
                }
            }
        }
    }


}