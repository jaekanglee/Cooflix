package com.kjk.core.data

class GenreRepository(
    private val genreDataSource: GenreDataSource
) {
    suspend fun getGenresInfo() = genreDataSource.getGenres()
}