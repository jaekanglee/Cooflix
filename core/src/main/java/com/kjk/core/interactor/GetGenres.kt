package com.kjk.core.interactor

import com.kjk.core.data.GenreRepository

class GetGenres(
    private val genreRepository: GenreRepository
) {

    suspend operator fun invoke() = genreRepository.getGenresInfo()
}