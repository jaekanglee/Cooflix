package presentation.main.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import domain.usecase.MovieUseCaseImpl
import javax.inject.Inject
import kotlinx.coroutines.launch
import presentation.main.item.group.MovieGroupListModel
import presentation.main.item.toModel

@HiltViewModel
class MainViewModel @Inject constructor(
    private val useCaseImpl: MovieUseCaseImpl
) : ViewModel() {

    private val _movieList = MutableLiveData<List<MovieGroupListModel>>()
    val movieList: LiveData<List<MovieGroupListModel>> get() = _movieList

    fun load() {
        viewModelScope.launch {
            val result = useCaseImpl.execute()
            val groupList = result.toModel().movieList.groupBy { it.genre }
            _movieList.value = groupList.map {
                MovieGroupListModel(
                    genre = it.key,
                    title = it.key.toString(),
                    movieList = it.value
                )
            }
        }
    }
}