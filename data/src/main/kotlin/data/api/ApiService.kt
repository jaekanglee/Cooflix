package data.api

import data.model.movie.MovieListResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("3/discover/movie")
    fun getMovieList(
        @Query("language") language: String = "ko-KR"
    ): Response<MovieListResponse>
}