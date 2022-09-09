package com.kjk.core.interactor

import com.kjk.core.data.MovieRepository

class GetMovies(
    private val movieRepository: MovieRepository
) {
    suspend operator fun invoke() =
        movieRepository.getAllMovies()
}