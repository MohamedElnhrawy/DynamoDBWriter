package com.example.domain.usecase

import com.example.common.Resource
import com.example.domain.entity.BookEntity
import com.example.domain.qualifiers.IoDispatcher
import com.example.domain.repository.Repository
import com.example.domain.usecase.core.BaseUseCase
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

/**
 * Use Case class for get Book
 */
class GetBooksUseCase @Inject constructor(
    private val repository: Repository,
    @IoDispatcher private val dispatcher: CoroutineDispatcher
) : BaseUseCase<BookEntity, String?>() {

    override suspend fun buildRequest(params: String?): Flow<Resource<List<BookEntity>>> {
        return  repository.getBooks().flowOn(dispatcher)
    }
}