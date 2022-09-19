package com.ppizil.presentaion.movielist

sealed class MovieListState {
    data class Success(val movies: List<MovieCategoryModel?>) : MovieListState()
    object Dismiss : MovieListState()
}
