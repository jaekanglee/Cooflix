package com.ppizil.presentaion.movielist

import androidx.lifecycle.viewModelScope
import com.ppizil.domain.usecase.FetchMovieList
import com.ppizil.presentaion.base.BaseViewModel
import com.ppizil.share.runSuspendCatching
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieListVm @Inject constructor(
    private val fetchMovieListUsecase: FetchMovieList
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
                    map {
                        it.mapToPresent()
                    }
                }
        }
            .onSuccess {
                seperateCateogyr(it)
            }
            .onFailure {

            }
    }


    private fun seperateCateogyr(item: List<ViewMovieModel>) = viewModelScope.launch {
        item.groupBy {
            it.category
        }
            .map {
                MovieCategoryModel(
                    category = it.key,
                    item = it.value
                )
            }
            .run {
                setUiState(MovieListState.Success(this))
                _movies.value = this
            }
    }
}