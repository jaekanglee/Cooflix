package com.kjk.couplix.framework.remote

import android.app.Application
import com.kjk.core.data.GenreRepository
import com.kjk.core.data.MovieRepository
import com.kjk.core.interactor.GetGenres
import com.kjk.core.interactor.GetMovies
import com.kjk.couplix.presentation.home.HomeViewModelFactory
import timber.log.Timber

class CouplixAppication : Application() {

    override fun onCreate() {
        super.onCreate()

        val genreRepository = GenreRepository(GenreDataSourceImpl())
        val movieRepository = MovieRepository(MovieDataSourceImpl())

        /**
         *  viewModel에서 interactor를 사용하기 위한 의존성 주입
         */
        HomeViewModelFactory.inject(
            this,
            Interactors(
                getGenres = GetGenres(genreRepository),
                getMovies = GetMovies(movieRepository)
            )
        )
        setTimber()
    }

    private fun setTimber() {
        Timber.plant(Timber.DebugTree())
    }
}