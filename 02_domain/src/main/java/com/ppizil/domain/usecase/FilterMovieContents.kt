package com.ppizil.domain.usecase

import com.ppizil.domain.model.ResultFilterredEntity
import com.ppizil.domain.model.ResultMovieEntity

interface FilterMovieContents {
    suspend operator fun invoke(items : List<ResultMovieEntity>) : List<ResultFilterredEntity>
}