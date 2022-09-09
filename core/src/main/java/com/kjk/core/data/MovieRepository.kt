package com.kjk.core.data

/**
 *  MovieDataSource 구현체를 던진다.
 */
class MovieRepository(
    private val movieDataSource: MovieDataSource
) {
    suspend fun getAllMovies() = movieDataSource.getMovies()
}