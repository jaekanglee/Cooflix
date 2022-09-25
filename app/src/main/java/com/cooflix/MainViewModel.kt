package com.cooflix

import androidx.lifecycle.*
import com.cooplix.model.GenreMovies
import com.cooplix.usecase.GetMoviesGroupUseCase
import kotlinx.coroutines.launch

class MainViewModel(private val getMoviesGroupUseCase: GetMoviesGroupUseCase): ViewModel() {
    private var _moviesGroup = MutableLiveData<List<GenreMovies>>()
    val moviesGroup: LiveData<List<GenreMovies>> = _moviesGroup

    init {
        getMovies()
    }

    private fun getMovies() {
        viewModelScope.launch {
            _moviesGroup.value = getMoviesGroupUseCase.invoke()
        }
    }
}