package presentation.main.item

import core.orDefault
import domain.model.MovieItemEntity
import domain.model.MovieListEntity
import presentation.main.item.movie.MovieItemModel
import presentation.main.item.movie.MovieListModel

fun MovieListEntity.toModel(): MovieListModel {
    return MovieListModel(
        movieList = results.toModel(),
    )
}

fun List<MovieItemEntity>.toModel(): List<MovieItemModel> {
    return map {
        MovieItemModel(
            id = it.id,
            title = it.title,
            genre = it.genreIds.firstOrNull().orDefault(-1),
            thumbnailImage = "https://image.tmdb.org/t/p/w500${it.posterPath}"
        )
    }
}