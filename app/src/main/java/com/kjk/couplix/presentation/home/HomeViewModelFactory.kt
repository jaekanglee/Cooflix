package com.kjk.couplix.presentation.home

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.kjk.couplix.framework.Interactors
import timber.log.Timber
import java.lang.IllegalStateException

/**
 *  의존성 주입을 위해
 *  ViewModelFactory를
 *  object로 singleton으로 생성한다.
 */
object HomeViewModelFactory: ViewModelProvider.Factory {

    private lateinit var application: Application
    private lateinit var dependency: Interactors

    fun inject(application: Application, dependency: Interactors) {
        HomeViewModelFactory.application = application
        HomeViewModelFactory.dependency = dependency
        Timber.d("$dependency")
    }

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (HomeViewModel::class.java.isAssignableFrom(modelClass)) {
            return modelClass.getConstructor(Interactors::class.java)
                .newInstance(dependency)
        }
        throw IllegalStateException("Unknown ViewModel Class")
    }

}