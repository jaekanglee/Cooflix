package com.ppizil.domain.repository

import com.ppizil.domain.model.ResultMovieEntity

interface MovieRepository {
    suspend fun fetchMovieList(param : Map<String,String>) : Result<List<ResultMovieEntity>>
}