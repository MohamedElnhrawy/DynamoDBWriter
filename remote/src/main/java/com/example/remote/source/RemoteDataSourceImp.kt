package com.example.remote.source

import com.example.common.Mapper
import com.example.data.model.BookDTO
import com.example.data.repository.RemoteDataSource
import com.example.remote.api.ApiService
import com.example.remote.model.BookResponseNetwork
import javax.inject.Inject


class RemoteDataSourceImp @Inject constructor(
    private val apiService : ApiService,
    private val bookMapper : Mapper<BookResponseNetwork, BookDTO>,
    ) : RemoteDataSource {
    override suspend fun getBooks(): List<BookDTO> {
        val networkData = apiService.getBooks().results
        return bookMapper.fromList(networkData)
    }




}