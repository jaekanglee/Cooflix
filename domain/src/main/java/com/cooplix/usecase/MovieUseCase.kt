package com.cooplix.usecase

import com.cooplix.model.Movie
import com.cooplix.repository.MovieRepository

class MovieUseCase(private val movieRepository: MovieRepository) {

    fun getMovies(): List<Movie> {
        return movieRepository.getMovie()
    }
}