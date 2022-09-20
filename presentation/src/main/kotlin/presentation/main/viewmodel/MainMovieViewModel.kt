package presentation.main.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import domain.usecase.GenreUseCaseImpl
import domain.usecase.MovieUseCaseImpl
import javax.inject.Inject
import kotlinx.coroutines.launch
import presentation.main.item.group.MovieGroupListModel
import presentation.main.item.toModel

@HiltViewModel
class MainMovieViewModel @Inject constructor(
    private val moveUseCase: MovieUseCaseImpl,
    private val genreUseCase: GenreUseCaseImpl
) : ViewModel() {

    private val _movieList = MutableLiveData<List<MovieGroupListModel>>()
    val movieList: LiveData<List<MovieGroupListModel>> get() = _movieList

    fun loadMovieList() {
        viewModelScope.launch {
            val movieList = moveUseCase.execute()
            val genreList = genreUseCase.execute()
            val groupList = movieList.toModel().movieList.groupBy { it.genre }
            _movieList.value = groupList.map { movie ->
                MovieGroupListModel(
                    genre = movie.key,
                    title = genreList.find { it.id == movie.key }?.name.orEmpty(),
                    movieList = movie.value
                )
            }
        }
    }
}