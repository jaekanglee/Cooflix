package com.cooflix

import com.cooplix.remote.api.MovieServiceFactory
import com.cooplix.repository.MovieRepository
import com.cooplix.repository.MovieRepositoryImpl
import com.cooplix.usecase.GetMoviesGroupUseCase
import com.cooplix.usecase.GetMoviesUseCase

class AppContainer {
    private val movieService = MovieServiceFactory.createService()
    private val movieRepository: MovieRepository = MovieRepositoryImpl(movieService)
    val getMoviesUseCase = GetMoviesUseCase(movieRepository)
    val getMoviesGroupUseCase = GetMoviesGroupUseCase(movieRepository)
}