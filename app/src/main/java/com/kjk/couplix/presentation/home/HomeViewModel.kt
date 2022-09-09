package com.kjk.couplix.presentation.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kjk.core.domain.Genre
import com.kjk.core.domain.Movie
import com.kjk.couplix.framework.Interactors
import kotlinx.coroutines.launch
import timber.log.Timber

class HomeViewModel(
    private val interactors: Interactors
) : ViewModel() {

    /**
     *  fetch 한 genre 정보를 hold하는 liveData
     */
    private val _genres = MutableLiveData<List<Genre>>()
    val genre: LiveData<List<Genre>>
        get() = _genres


    /**
     *  fetch한 영화 정보를 hold하는 liveData
     */
    private val _movies = MutableLiveData<List<Movie>>()
    val movies: LiveData<List<Movie>>
        get() = _movies


    init {
        Timber.d("here")
        fetchAllGenres()
        fetchAllMovies()
    }


    private fun fetchAllGenres() {
        viewModelScope.launch {
            _genres.postValue(interactors.getGenres())
        }
    }


    private fun fetchAllMovies() {
        viewModelScope.launch {
            _movies.postValue(interactors.getMovies())
        }
    }
}