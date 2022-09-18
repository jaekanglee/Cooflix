package domain.usecase

import domain.model.MovieListEntity
import domain.repository.MovieRepository
import javax.inject.Inject

class MovieUseCaseImpl @Inject constructor(
    private val repository: MovieRepository
) {
    suspend fun execute(): MovieListEntity = repository.getMovieList()
}