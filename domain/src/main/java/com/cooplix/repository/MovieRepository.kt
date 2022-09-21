package com.cooplix.repository

import com.cooplix.model.Movie
import com.cooplix.model.MovieGenre

interface MovieRepository {
    suspend fun getMovies(): List<Movie>

    suspend fun getMoviesGroup(): Map<MovieGenre, List<Movie>>
}