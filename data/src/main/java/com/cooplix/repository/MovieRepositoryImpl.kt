package com.cooplix.repository

import com.cooplix.model.GenreMovies
import com.cooplix.model.Movie
import com.cooplix.model.MovieGenre
import com.cooplix.remote.api.MovieService

class MovieRepositoryImpl(private val movieService: MovieService): MovieRepository {


    override suspend fun getMovies(): List<Movie> {
        return movieService.getMovie().toMovies(getMovieGenres()) ?: emptyList()
    }

    override suspend fun getMoviesGroup(): List<GenreMovies> {
        val movies = movieService.getMovie().toMovies(getMovieGenres())
        val moviesGroup = movies?.map {
            GenreMovies(
                it.genres.firstOrNull() ?: return emptyList(),
                movies
            )
        }

        return moviesGroup ?: emptyList()
    }

    private suspend fun getMovieGenres(): List<MovieGenre>? = movieService.getMovieGenres().genres?.mapNotNull {
        it.toMovieGenre()
    }
}