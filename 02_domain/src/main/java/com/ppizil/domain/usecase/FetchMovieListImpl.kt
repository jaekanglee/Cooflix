package com.ppizil.domain.usecase

import com.ppizil.domain.model.ParamMovieEntity
import com.ppizil.domain.model.ResultMovieEntity
import com.ppizil.domain.repository.MovieRepository
import javax.inject.Inject

class FetchMovieListImpl @Inject constructor(
    private val createMovieListParam: CreateMovieListParam,
    private val repo: MovieRepository
) : FetchMovieList {
    override suspend fun invoke(param: ParamMovieEntity): List<ResultMovieEntity> =
        createMovieListParam(param)
            .run {
                repo.fetchMovieList(this)
            }.getOrThrow()

}