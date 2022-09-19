package com.ppizil.presentaion.base


import androidx.lifecycle.ViewModel
import kotlinx.coroutines.Dispatchers
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.cancel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch


abstract class BaseViewModel<T> : ViewModel() {

    private val _uiState = MutableEventFlow<T?>()
    val uiState = _uiState.asEventFlow()
        .stateIn(
            initialValue = null,
            scope = viewModelScope,
            started = SharingStarted.Eagerly
        )


    private val actionFlow = MutableSharedFlow<suspend () -> Unit>(replay = 0)

    init {
        actionFlow

            .throttleFirst()
            .onEach { action ->
                action()
            }
            .flowOn(Dispatchers.Unconfined)
            .launchIn(viewModelScope)
    }

    suspend fun onThrottleFirstAction(action: suspend () -> Unit) {
        actionFlow.emit(action)
    }


    protected fun setUiState(state: T) = viewModelScope.launch {
        _uiState.emit(state)
    }

//    fun mapToError(e: Throwable): PopupModel =
//        when (e) {
//            is PopupModel -> e
//            is IssueDomainModel -> e.mapToPresent()
//            else -> PopupModel(
//                PopupTypes.UnCaughtException,
//                e.localizedMessage
//            )
//        }

    // 마지막 발행 시간과 현재 시간 비교해서 이벤트 발행, 나머지는 무시.
    fun <T> Flow<T>.throttleFirst(): Flow<T> = flow {
        var lastEmissionTime = 0L
        collect { upstream ->
            val currentTime = System.currentTimeMillis()
            if (currentTime - lastEmissionTime > 500) {
                lastEmissionTime = currentTime
                emit(upstream)
            }
        }
    }

    override fun onCleared() {
        viewModelScope.cancel()
        super.onCleared()
    }
}
