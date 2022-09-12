package com.cooplix.remote.api

import com.cooplix.remote.dto.response.MovieResponseDto
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieService {
    @GET("/discover/movie")
    fun getMovie(
        @Query("api_key") apiKey: String,
        @Query("language") language: String,
        @Query("page") page: Int
    ): MovieResponseDto
}