package com.cooplix.repository

import com.cooplix.model.Movie
import com.cooplix.model.MovieGenre
import com.cooplix.remote.api.MovieService

class MovieRepositoryImpl(private val movieService: MovieService): MovieRepository {


    override suspend fun getMovies(): List<Movie> {
        return movieService.getMovie().toMovies(getMovieGenres()) ?: emptyList()
    }

    override suspend fun getMoviesGroup(): Map<MovieGenre, List<Movie>> {
        val movies = movieService.getMovie().toMovies(getMovieGenres())

        return movies?.groupBy {
            it.genres.firstOrNull() ?: return emptyMap()
        } ?: emptyMap()
    }

    private suspend fun getMovieGenres(): List<MovieGenre>? = movieService.getMovieGenres().genres?.mapNotNull {
        it.toMovieGenre()
    }
}