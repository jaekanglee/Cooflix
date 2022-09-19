package com.ppizil.domain.usecase

import com.ppizil.domain.model.ResultFilterredEntity
import com.ppizil.domain.model.ResultMovieEntity
import javax.inject.Inject

class FilterMovieContentsImpl @Inject constructor() : FilterMovieContents {
    override suspend fun invoke(items: List<ResultMovieEntity>): List<ResultFilterredEntity> =
        items.groupBy {
            it.category
        }
            .map {
                ResultFilterredEntity(
                    category = it.key,
                    movies = it.value
                )
            }

}