package com.cooflix

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.cooplix.model.GenreMovies

class MainViewModel: ViewModel() {
    private var _movies = MutableLiveData<GenreMovies>()
    val movies: LiveData<GenreMovies> = _movies

    init {

    }
}