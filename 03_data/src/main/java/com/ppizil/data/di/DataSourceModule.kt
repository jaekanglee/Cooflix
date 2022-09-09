package com.ppizil.data.di

import com.ppizil.data.datasource.MovieRemoteSource
import com.ppizil.data.datasource.MovieRemoteSourceImpl
import com.ppizil.service.MovieRemoteService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataSourceModule {

    @Provides
    @Singleton
    fun provideMovieRemoteSource(
        service : MovieRemoteService
    ) : MovieRemoteSource = MovieRemoteSourceImpl(service)
}