package com.cooplix.usecase

import com.cooplix.model.Movie
import com.cooplix.repository.MovieRepository

class GetMovieUseCase(private val movieRepository: MovieRepository) {

    operator fun invoke(): List<Movie> {
        return movieRepository.getMovie()
    }
}