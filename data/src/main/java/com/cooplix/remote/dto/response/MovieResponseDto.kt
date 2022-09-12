package com.cooplix.remote.dto.response

import com.cooplix.model.Movie
import com.cooplix.model.MovieGenre
import com.squareup.moshi.Json

data class MovieResponseDto(
    @Json(name="pages")
    val page: Int,
    @Json(name="results")
    val results: List<MovieDto>
) {
    fun toMovies(movieGenres: List<MovieGenre>): List<Movie> {
        return this.results.map { movieDto ->
            movieDto.toMovie(movieGenres.filter { movieGenre ->
                movieDto.genreIds.any { it == movieGenre.id }
            })
        }
    }

    data class MovieDto(
        @Json(name="id")
        val id: Int,
        @Json(name="title")
        val title: String,
        @Json(name="genre_ids")
        val genreIds: List<Int>,
        @Json(name="poster_path")
        val posterPath: String?
    ) {

        fun toMovie(genres: List<MovieGenre>): Movie {
            return Movie(
                id = this.id,
                title = this.title,
                genres = genres,
                posterPath = this.posterPath ?: ""
            )
        }
    }
}