package com.ppizil.domain.usecase

import com.ppizil.domain.model.ParamMovieEntity
import com.ppizil.domain.model.ResultMovieEntity

interface FetchMovieList {
    suspend operator fun invoke(param: ParamMovieEntity): List<ResultMovieEntity>
}