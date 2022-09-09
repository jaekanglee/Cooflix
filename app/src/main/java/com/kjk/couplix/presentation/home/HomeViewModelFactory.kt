package com.kjk.couplix.presentation.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.kjk.couplix.framework.remote.Interactors
import java.lang.IllegalStateException

class HomeViewModelFactory(
    private val interactors: Interactors
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(HomeViewModel::class.java)) {
            return HomeViewModelFactory(interactors) as T
        }
        throw IllegalStateException("Unknown ViewModel Class")
    }
}