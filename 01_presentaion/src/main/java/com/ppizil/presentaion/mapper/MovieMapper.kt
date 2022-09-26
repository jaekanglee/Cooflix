package com.ppizil.presentaion.movielist

import com.ppizil.domain.model.ParamMovieEntity
import com.ppizil.domain.model.ResultFilterredEntity
import com.ppizil.domain.model.ResultMovieEntity
import com.ppizil.presentaion.model.movielist.MovieCategoryModel
import com.ppizil.presentaion.model.movielist.MovieModel
import com.ppizil.presentaion.model.movielist.ViewMovieModel


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


fun ResultFilterredEntity.mapToPresent(): MovieCategoryModel =
    MovieCategoryModel(
        category = category.mapToCategory(),
        item = movies.map { it.mapToPresent() }
    )