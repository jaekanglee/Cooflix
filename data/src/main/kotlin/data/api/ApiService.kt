package data.api

import data.model.movie.MovieListResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("3/discover/movie")
    suspend fun getMovieList(
        @Query("api_key") apiKey: String = "5ecf5e632c3cac7f822f462c382a77a5",
        @Query("language") language: String = "ko-KR"
    ): Response<MovieListResponse>
}