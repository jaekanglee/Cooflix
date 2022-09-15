package domain.repository

import domain.model.MovieListEntity

interface MovieRepository {
    suspend fun getMovieList(): MovieListEntity
}