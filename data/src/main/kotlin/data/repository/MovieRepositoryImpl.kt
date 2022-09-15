package data.repository

import data.api.ApiService
import data.model.movie.toEntity
import domain.model.MovieListEntity
import domain.repository.MovieRepository
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(
    private val apiService: ApiService
) : MovieRepository {
    override fun getMovieList(): MovieListEntity {
        return apiService.getMovieList().body().toEntity()
    }
}