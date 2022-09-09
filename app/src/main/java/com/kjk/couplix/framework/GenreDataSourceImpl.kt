package com.kjk.couplix.framework

import com.kjk.core.data.GenreDataSource
import com.kjk.core.domain.Genre
import com.kjk.couplix.framework.remote.network.MovieApi

class GenreDataSourceImpl : GenreDataSource {

    private val movieApi = MovieApi.movieApiService

    override suspend fun getGenres(): List<Genre> {
        return movieApi.getAllGenres().genres
            .map {
                Genre(
                    genreId = it.genreId,
                    genreType = it.genreType
                )
            }
    }
}