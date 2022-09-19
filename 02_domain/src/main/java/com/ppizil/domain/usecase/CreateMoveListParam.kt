package com.ppizil.domain.usecase

import com.ppizil.domain.model.ParamMovieEntity

interface CreateMovieListParam {
    suspend operator fun invoke(param: ParamMovieEntity): HashMap<String, String>
}