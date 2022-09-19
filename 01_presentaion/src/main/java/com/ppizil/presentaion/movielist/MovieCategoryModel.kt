package com.ppizil.presentaion.movielist

import com.ppizil.presentaion.movielist.MovieModel

data class MovieCategoryModel(
    val category: MovieCategories,
    val item : List<ViewMovieModel>
)