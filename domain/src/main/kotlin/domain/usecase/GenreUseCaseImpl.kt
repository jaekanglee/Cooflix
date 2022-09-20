package domain.usecase

import domain.model.GenreItemEntity
import domain.repository.MovieRepository
import javax.inject.Inject

class GenreUseCaseImpl @Inject constructor(
    private val repository: MovieRepository
) {
    suspend fun execute(): List<GenreItemEntity> = repository.getMovieGenreList()

}