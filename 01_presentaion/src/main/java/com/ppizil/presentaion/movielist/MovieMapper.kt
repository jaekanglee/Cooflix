package com.ppizil.presentaion.movielist

import com.ppizil.domain.model.ParamMovieEntity
import com.ppizil.domain.model.ResultMovieEntity


fun ResultMovieEntity.mapToPresent() = ViewMovieModel(
    id = id,
    title = title,
    contents = desc,
    imageUrl = imageUrl,
    category = category.mapToCategory(),
)


fun MovieModel.mapToDomain() = ParamMovieEntity(
    language = language,
    region = region
)
