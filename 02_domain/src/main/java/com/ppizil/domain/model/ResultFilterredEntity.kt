package com.ppizil.domain.model

data class ResultFilterredEntity(
    val category: Int,
    val movies: List<ResultMovieEntity>
)