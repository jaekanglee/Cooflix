package com.kjk.core.data

import com.kjk.core.domain.Movie

/**
 *  Framework layer에서 해당 dataSource를 구현한다.
 *
 *  Repository가 dataSource를 사용한다.
 */
interface MovieDataSource {
    suspend fun getMovies(): List<Movie>
}