package com.cooplix.usecase

import com.cooplix.repository.MovieRepository

class GetMoviesGroupUseCase(private val movieRepository: MovieRepository) {
    suspend operator fun invoke() = movieRepository.getMoviesGroup()
}