package com.cooplix.repository

import com.cooplix.model.Movie

interface MovieRepository {
    fun getMovies(): List<Movie>
}