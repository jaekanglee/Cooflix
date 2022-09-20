package domain.repository

import domain.model.GenreItemEntity
import domain.model.MovieListEntity

interface MovieRepository {
    suspend fun getMovieList(): MovieListEntity
    suspend fun getMovieGenreList(): List<GenreItemEntity>
}