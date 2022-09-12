package com.cooplix.remote.dto.response

import com.squareup.moshi.Json

data class MovieResponseDto(
    @Json(name="pages")
    val page: Int,
    @Json(name="results")
    val results: List<MovieDto>
) {
    data class MovieDto(
        @Json(name="title")
        val title: String,
        @Json(name="genre_ids")
        val genreIds: List<Int>,
        @Json(name="poster_path")
        val posterPath: String?
    )
}