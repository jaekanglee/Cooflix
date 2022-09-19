package com.ppizil.domain.di

import com.ppizil.domain.repository.MovieRepository
import com.ppizil.domain.usecase.CreateMoveListParam
import com.ppizil.domain.usecase.CreateMoveListParamImpl
import com.ppizil.domain.usecase.FetchMovieList
import com.ppizil.domain.usecase.FetchMovieListImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DomainModule {

    @Provides
    @Singleton
    fun provideCreateMoveListParam(): CreateMoveListParam = CreateMoveListParamImpl()

    @Provides
    @Singleton
    fun provideFetchMovieList(
        createMoveListParam : CreateMoveListParam,
        repo : MovieRepository
    ): FetchMovieList = FetchMovieListImpl(
        createMoveListParam,
        repo
    )
}