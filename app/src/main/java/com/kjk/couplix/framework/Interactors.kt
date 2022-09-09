package com.kjk.couplix.framework

import com.kjk.core.interactor.GetGenres
import com.kjk.core.interactor.GetMovies

/**
 *  viewModel로 usecase들을 주입하기 위한
 *  data class
 */
data class Interactors(
    val getGenres: GetGenres,
    val getMovies: GetMovies
)