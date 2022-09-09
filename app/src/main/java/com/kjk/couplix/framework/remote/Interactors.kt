package com.kjk.couplix.framework.remote

import com.kjk.core.interactor.GetGenres
import com.kjk.core.interactor.GetMovies

data class Interactors(
    val getGenres: GetGenres,
    val getMovies: GetMovies
)