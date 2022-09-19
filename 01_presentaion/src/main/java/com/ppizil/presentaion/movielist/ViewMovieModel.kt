package com.ppizil.presentaion.movielist

data class ViewMovieModel(
    val id: Long?,
    val title: String?,
    val contents: String?,
    val imageUrl: String?,
    val category: MovieCategories,
)
