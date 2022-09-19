package com.ppizil.data.mapper

import com.ppizil.data.model.movie.MovieDto
import com.ppizil.data.model.movie.ResponseMovieDto
import com.ppizil.domain.model.ResultMovieEntity

fun ResponseMovieDto.mapToDomain() = results.map {
    it.mapToDomain()
}

fun MovieDto.mapToDomain() = ResultMovieEntity(
    id = id,
    title = title ?: "-",
    desc = overview ?: "-",
    imageUrl = poster_path ?: "-",
    category = genre_ids?.firstOrNull() ?: -1 // -1은 분류되지 않은 장르 즉 Erorr
)