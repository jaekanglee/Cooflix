package com.kjk.couplix.framework.remote.response

data class MovieApiResponse(
    val page: Int,
    val results: List<MovieEntity>
)