package com.cooplix.remote.dto.response

import com.cooplix.model.MovieGenre
import com.squareup.moshi.Json

data class MovieGenresDto(
    @Json(name="genres")
    val genres: List<MovieGenreDto>?
) {
    data class MovieGenreDto(
        @Json(name="id")
        val id: Int?,
        @Json(name="name")
        val name: String?
    ) {
        fun toMovieGenre(): MovieGenre? {
            return MovieGenre(
                id = this.id ?: return null,
                name = this.name ?: return null
            )
        }
    }
}