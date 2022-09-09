package com.kjk.core.data

import com.kjk.core.domain.Genre

interface GenreDataSource {
    suspend fun getGenres(): List<Genre>
}