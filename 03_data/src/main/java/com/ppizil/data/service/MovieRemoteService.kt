package com.ppizil.data.service

import com.ppizil.data.model.movie.ResponseMovieDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.QueryMap

interface MovieRemoteService {
    @GET("/3/discover/movie")
    suspend fun fetchMovieList(
        @QueryMap param: Map<String, String>
    ): Response<ResponseMovieDto>
}