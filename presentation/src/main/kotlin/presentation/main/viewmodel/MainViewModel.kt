package presentation.main.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import domain.usecase.MovieUseCaseImpl
import javax.inject.Inject
import kotlinx.coroutines.launch

@HiltViewModel
class MainViewModel @Inject constructor(
    private val useCaseImpl: MovieUseCaseImpl
) : ViewModel() {

    fun load() {
        viewModelScope.launch {
            val result = useCaseImpl.execute()
        }
    }
}