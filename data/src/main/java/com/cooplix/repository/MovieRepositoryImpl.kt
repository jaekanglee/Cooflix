package com.cooplix.repository

import com.cooplix.BuildConfig
import com.cooplix.model.Movie
import com.cooplix.model.MovieGenre
import com.cooplix.remote.api.MovieService

class MovieRepositoryImpl(private val movieService: MovieService): MovieRepository {

    private val apiKey = BuildConfig.api_key

    override suspend fun getMovies(): List<Movie> {
        return movieService.getMovie(apiKey).toMovies(getMovieGenres())
    }

    override suspend fun getMoviesGroup(): Map<MovieGenre, List<Movie>> {
        val movies = movieService.getMovie(apiKey).toMovies(getMovieGenres())

        return movies.groupBy { it.genres[0] }
    }

    private suspend fun getMovieGenres() = movieService.getMovieGenres(apiKey).genres.map {
        it.toMovieGenre()
    }
}