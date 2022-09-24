package com.cooflix

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.cooplix.model.GenreMovies

class MainViewModel: ViewModel() {
    private var _moviesGroup = MutableLiveData<List<GenreMovies>>()
    val moviesGroup: LiveData<List<GenreMovies>> = _moviesGroup

    init {

    }
}