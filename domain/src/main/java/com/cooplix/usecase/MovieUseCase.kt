package com.cooplix.usecase

import com.cooplix.model.Movie
import com.cooplix.repository.MovieRepository

class MovieUseCase(val movieRepository: MovieRepository) {

    fun getMovie(): List<Movie> {
        return movieRepository.getMovie()
    }
}