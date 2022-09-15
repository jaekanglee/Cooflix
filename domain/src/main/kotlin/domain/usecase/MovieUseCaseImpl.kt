package domain.usecase

import domain.model.MovieListEntity
import domain.repository.MovieRepository
import javax.inject.Inject

class MovieUseCaseImpl @Inject constructor(
    private val repository: MovieRepository
) : MovieUseCase {

    suspend fun execute(): MovieListEntity {
        return repository.getMovieList()
    }

}