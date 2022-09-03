package com.cooplix.repository

import com.cooplix.model.Movie

interface MovieRepository {
    fun getMovie(): List<Movie>
}