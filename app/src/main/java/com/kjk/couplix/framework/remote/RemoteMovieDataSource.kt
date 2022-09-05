package com.kjk.couplix.framework.remote

import com.kjk.core.data.MovieDataSource
import com.kjk.core.domain.Movie
import com.kjk.couplix.framework.remote.network.MovieApi
import timber.log.Timber

class RemoteMovieDataSource : MovieDataSource {

    private val movieApi = MovieApi.movieApiService

    override suspend fun getMovies(): List<Movie> {
        return movieApi.getAllMovies().results
            .apply {
                Timber.d("${this}")
            }
            .map {
                Movie(
                    posterPath = it.posterPath,
                    adult = it.adult,
                    overview = it.overview,
                    releaseDate = it.releaseDate,
                    genresId = it.genresId,
                    id = it.id,
                    originalTitle = it.originalTitle,
                    originalLanguage = it.originalLanguage,
                    title = it.title,
                    backdropPath = it.backdropPath,
                    popularity = it.popularity,
                    voteCount = it.voteCount,
                    video = it.video,
                    voteAverage = it.voteAverage
                )
            }
    }
}