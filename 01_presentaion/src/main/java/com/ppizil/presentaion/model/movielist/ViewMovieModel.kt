package com.ppizil.presentaion.model.movielist

import com.ppizil.presentaion.movielist.MovieCategories

data class ViewMovieModel(
    val id: Long?,
    val title: String?,
    val contents: String?,
    val imageUrl: String?,
    val category: MovieCategories,
)
