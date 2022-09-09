package com.ppizil.data.datasource

import com.ppizil.data.model.movie.ResponseMovieDto
import com.ppizil.service.MovieRemoteService
import com.ppizil.share.runSuspendCatching
import javax.inject.Inject

class MovieRemoteSourceImpl @Inject constructor(
    private val service: MovieRemoteService
) : BaseSource(), MovieRemoteSource {
    override suspend fun fetchMovieList(params: Map<String, String>): Result<ResponseMovieDto> =
        runSuspendCatching {
            this(service.fetchMovieList(params))
        }
}