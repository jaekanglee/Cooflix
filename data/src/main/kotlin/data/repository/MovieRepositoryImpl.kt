package data.repository

import data.api.ApiService
import data.model.movie.toEntity
import domain.model.GenreItemEntity
import domain.model.MovieListEntity
import domain.repository.MovieRepository
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(
    private val apiService: ApiService
) : MovieRepository {
    override suspend fun getMovieList(): MovieListEntity =
        apiService.getMovieList().body().toEntity()

    override suspend fun getMovieGenreList(): List<GenreItemEntity> =
        apiService.getMovieGenreList().body().toEntity()
}