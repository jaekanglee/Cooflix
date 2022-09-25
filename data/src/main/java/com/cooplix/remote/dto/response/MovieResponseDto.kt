package com.cooplix.remote.dto.response

import com.cooplix.model.Movie
import com.cooplix.model.MovieGenre
import com.squareup.moshi.Json

data class MovieResponseDto(
    @Json(name="pages")
    val page: Int?,
    @Json(name="results")
    val results: List<MovieDto>?
) {
    fun toMovies(movieGenres: List<MovieGenre>?): List<Movie>? {
        return this.results?.mapNotNull { movieDto ->
            val filteringMovieGenres = movieGenres?.filter { movieGenre ->
                movieDto.genreIds?.any { it == movieGenre.id } ?: false
            }?.takeIf { it.isNotEmpty() }
            movieDto.toMovie(filteringMovieGenres)
        }
    }

    data class MovieDto(
        @Json(name="id")
        val id: Int?,
        @Json(name="title")
        val title: String?,
        @Json(name="genre_ids")
        val genreIds: List<Int>?,
        @Json(name="poster_path")
        val posterPath: String?
    ) {

        fun toMovie(genres: List<MovieGenre>?): Movie? {
            return Movie(
                id = this.id ?: return null,
                title = this.title ?: return null,
                genres = genres ?: return null,
                posterPath = "https://www.themoviedb.org/t/p/w440_and_h660_face" + this.posterPath
            )
        }
    }
}