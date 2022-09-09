package com.kjk.couplix.presentation.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kjk.core.domain.Movie
import com.kjk.couplix.framework.remote.Interactors
import kotlinx.coroutines.launch

class HomeViewModel(
    private val interactors: Interactors
) : ViewModel() {

    private val _movies = MutableLiveData<List<Movie>>()
    val movies: LiveData<List<Movie>>
        get() = _movies


    init {
        fetchAllMovies()
    }

    private fun fetchAllMovies() {
        viewModelScope.launch {
            _movies.postValue(interactors.getMovies.invoke())
        }
    }
}