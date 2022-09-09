package com.ppizil.data.repository

import com.ppizil.data.BuildConfig
import com.ppizil.data.datasource.MovieRemoteSource
import com.ppizil.data.mapper.mapToDomain
import com.ppizil.domain.model.ResultMovieEntity
import com.ppizil.domain.repository.MovieRepository
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(
    private val source: MovieRemoteSource
) : MovieRepository {
    override suspend fun fetchMovieList(param: Map<String, String>): Result<List<ResultMovieEntity>> =
        param.toMutableMap().apply {
            put("api_key",BuildConfig.API_KEY)
        }.run {
            source.fetchMovieList(this)
        }
            .mapCatching {
                it.mapToDomain()
            }
}