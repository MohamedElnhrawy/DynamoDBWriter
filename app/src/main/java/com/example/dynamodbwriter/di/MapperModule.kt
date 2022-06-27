package com.example.dynamodbwriter.di

import com.example.common.Mapper
import com.example.data.mapper.BookDataDomainMapper
import com.example.data.model.BookDTO
import com.example.domain.entity.BookEntity
import com.example.feature.mapper.BookDomainUiMapper
import com.example.feature.model.BookUiModel
import com.example.local.mapper.BookLocalDataMapper
import com.example.local.model.BookLocalModel
import com.example.remote.mapper.BookNetworkDataMapper
import com.example.remote.model.BookResponseNetwork
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

/**
 * Module that holds Mappers
 */
@Module
@InstallIn(SingletonComponent::class)
abstract class MapperModule {

    //region Locale Mappers
    @Binds
    abstract fun bindsBookLocalDataMapper(mapper : BookLocalDataMapper) : Mapper<BookLocalModel, BookDTO>
    //endregion


    //region Data Mappers
    @Binds
    abstract fun bindsBookDataDomainMapper(mapper : BookDataDomainMapper) : Mapper<BookDTO, BookEntity>

    //endregion


    //region Presentation Mappers
    @Binds
    abstract fun bindsBookDomainUiMapper(mapper : BookDomainUiMapper) : Mapper<BookEntity, BookUiModel>
    //endregion


    //region Remote Mappers
    @Binds
    abstract fun bindsBookNetworkDataMapper(mapper: BookNetworkDataMapper): Mapper<BookResponseNetwork, BookDTO>
    //endregion
}