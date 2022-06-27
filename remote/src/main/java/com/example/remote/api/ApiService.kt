package com.example.remote.api

import com.example.remote.model.ApiResponseNetwork
import com.example.remote.model.BookResponseNetwork
import retrofit2.http.GET


interface ApiService {
    @GET("dynamodb-writer")
    suspend fun getBooks() : ApiResponseNetwork

}