package com.cooplix.model

data class Movie(
    val id: Int,
    val title: String,
    val genres: List<MovieGenre>
)