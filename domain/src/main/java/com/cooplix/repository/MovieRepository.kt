package com.cooplix.repository

import com.cooplix.model.GenreMovies
import com.cooplix.model.Movie

interface MovieRepository {
    suspend fun getMovies(): List<Movie>

    suspend fun getMoviesGroup(): List<GenreMovies>
}