package com.ppizil.data.di

import com.ppizil.data.datasource.MovieRemoteSource
import com.ppizil.data.repository.MovieRepositoryImpl
import com.ppizil.domain.repository.MovieRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideMovieRepository(
        source : MovieRemoteSource
    ) : MovieRepository = MovieRepositoryImpl(source)
}