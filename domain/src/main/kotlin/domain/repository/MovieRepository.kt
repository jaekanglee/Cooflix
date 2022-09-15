package domain.repository

import domain.model.MovieListEntity

interface MovieRepository {
    fun getMovieList(): MovieListEntity
}