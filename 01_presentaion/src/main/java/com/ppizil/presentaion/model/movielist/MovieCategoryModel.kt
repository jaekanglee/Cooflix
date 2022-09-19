package com.ppizil.presentaion.model.movielist

import com.ppizil.presentaion.movielist.MovieCategories

data class MovieCategoryModel(
    val category: MovieCategories,
    val item : List<ViewMovieModel>
)