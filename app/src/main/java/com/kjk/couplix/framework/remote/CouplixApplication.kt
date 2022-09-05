package com.kjk.couplix.framework.remote

import android.app.Application
import com.kjk.core.data.MovieDataSource
import com.kjk.core.data.MovieRepository
import timber.log.Timber

class CouplixApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        Timber.plant(Timber.DebugTree())

        val movieRepository = MovieRepository(RemoteMovieDataSource())
    }
}