package com.ppizil.domain.di

import com.ppizil.domain.repository.MovieRepository
import com.ppizil.domain.usecase.*
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
    fun provideCreateMoveListParam(): CreateMovieListParam =CreateMovieListParamImpl()

    @Provides
    @Singleton
    fun provideFetchMovieList(
        createMoveListParam : CreateMovieListParam,
        repo : MovieRepository
    ): FetchMovieList = FetchMovieListImpl(
        createMoveListParam,
        repo
    )

    @Provides
    @Singleton
    fun provideFilterringMovieList() : FilterMovieContents = FilterMovieContentsImpl()
}