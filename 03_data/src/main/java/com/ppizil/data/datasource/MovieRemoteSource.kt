package com.ppizil.data.datasource

import com.ppizil.data.model.movie.ResponseMovieDto

interface MovieRemoteSource {
    suspend fun fetchMovieList(params: Map<String, String>): Result<ResponseMovieDto>
}