package com.ppizil.presentaion.movielist

import com.ppizil.presentaion.model.movielist.MovieCategoryModel

sealed class MovieListState {
    data class Success(val movies: List<MovieCategoryModel?>) : MovieListState()
    object Dismiss : MovieListState()
}
