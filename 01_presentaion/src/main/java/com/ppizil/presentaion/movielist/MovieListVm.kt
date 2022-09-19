package com.ppizil.presentaion.movielist

import androidx.lifecycle.viewModelScope
import com.ppizil.domain.usecase.FetchMovieList
import com.ppizil.domain.usecase.FilterMovieContents
import com.ppizil.presentaion.base.BaseViewModel
import com.ppizil.presentaion.model.movielist.MovieCategoryModel
import com.ppizil.presentaion.model.movielist.MovieModel
import com.ppizil.presentaion.model.movielist.ViewMovieModel
import com.ppizil.share.runSuspendCatching
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieListVm @Inject constructor(
    private val fetchMovieListUsecase: FetchMovieList,
    private val filterMovieContents: FilterMovieContents
) : BaseViewModel<MovieListState>() {

    private val _movies = MutableStateFlow<List<MovieCategoryModel>>(emptyList())
    val movies = _movies.asStateFlow()


    fun fetchMoveiList() = viewModelScope.launch {
        runSuspendCatching {
            MovieModel(
                language = null,
                region = null
            )
                .run {
                    mapToDomain()
                }
                .run {
                    fetchMovieListUsecase(this)
                }
                .run {
                    filterMovieContents(this)
                }
                .map {
                    it.mapToPresent()
                }
        }
            .onSuccess {
                _movies.value = it
                setUiState(MovieListState.Success(it))
            }
            .onFailure {

            }
    }
}