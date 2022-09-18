package com.cooplix.remote.api

import com.cooplix.BuildConfig
import com.cooplix.remote.dto.response.MovieGenresDto
import com.cooplix.remote.dto.response.MovieResponseDto
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieService {

    @GET("/discover/movie")
    suspend fun getMovie(
        @Query("api_key") apiKey: String = BuildConfig.api_key
    ): MovieResponseDto

    @GET("/genre/movie/list")
    suspend fun getMovieGenres(
        @Query("api_key") apiKey: String = BuildConfig.api_key
    ): MovieGenresDto
}