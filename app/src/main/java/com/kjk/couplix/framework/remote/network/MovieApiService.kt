package com.kjk.couplix.framework.remote.network

import com.kjk.couplix.framework.remote.response.GenreEntity
import com.kjk.couplix.framework.remote.response.MovieApiResponse
import com.kjk.couplix.framework.remote.response.MovieEntity
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

private const val BASE_URL = "https://api.themoviedb.org/3"
private const val API_KEY = ""

interface MovieApiService {

    @GET("/discover/movie")
    suspend fun getAllMovies(
        @Query("api_key") apiKey: String = API_KEY,
        @Query("language") language: String = "en-US",
        @Query("sort_by") sortBy: String = "popularity.desc",
        @Query("page") page: Int = 1
    ): MovieApiResponse


    @GET("/genre/movie/list")
    suspend fun getAllGenres(
        @Query("api_key") apiKey: String = API_KEY,
        @Query("language") language: String = ""
    ): List<GenreEntity>
}

object MovieApi {

    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val movieApiService: MovieApiService by lazy {
        retrofit.create(MovieApiService::class.java)
    }
}