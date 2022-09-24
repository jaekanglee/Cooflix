package com.cooplix.usecase

import com.cooplix.model.Movie
import com.cooplix.repository.MovieRepository

class GetMoviesUseCase(private val movieRepository: MovieRepository) {

    suspend operator fun invoke(): List<Movie> {
        return movieRepository.getMovies()
    }
}