package data.model.movie

import core.orFalse
import core.orZero
import domain.model.GenreItemEntity
import domain.model.MovieItemEntity
import domain.model.MovieListEntity

fun MovieListResponse?.toEntity(): MovieListEntity {
    return MovieListEntity(
        page = this?.page.orZero(),
        results = this?.results.toEntity(),
        totalPages = this?.totalPages.orZero(),
        totalResults = this?.totalResults.orZero(),
    )
}

fun List<MovieItemResponse>?.toEntity(): List<MovieItemEntity> {
    return this?.map {
        MovieItemEntity(
            adult = it.adult.orFalse(),
            backdropPath = it.backdropPath.orEmpty(),
            genreIds = it.genreIds.orEmpty(),
            id = it.id.orZero(),
            originalLanguage = it.originalLanguage.orEmpty(),
            originalTitle = it.originalTitle.orEmpty(),
            overview = it.overview.orEmpty(),
            popularity = it.popularity.orZero(),
            posterPath = it.posterPath.orEmpty(),
            releaseDate = it.releaseDate.orEmpty(),
            title = it.title.orEmpty(),
            video = it.video.orFalse(),
            voteAverage = it.voteAverage.orZero(),
            voteCount = it.voteCount.orZero(),
        )
    }.orEmpty()
}

fun GenreListResponse?.toEntity(): List<GenreItemEntity> {
    return this?.genres?.map {
        GenreItemEntity(
            id = it.id.orZero(),
            name = it.name.orEmpty()
        )
    }.orEmpty()
}