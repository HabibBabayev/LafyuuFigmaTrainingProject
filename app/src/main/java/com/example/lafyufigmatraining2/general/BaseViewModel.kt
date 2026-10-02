package com.example.lafyufigmatraining2.general

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

abstract class BaseViewModel<state,event>(
): ViewModel() {
    protected abstract val initialState:state
private val _uiState= MutableStateFlow(initialState)
    val uiState get() = _uiState.asStateFlow()

    abstract fun onEvent(event: event)
    fun updateState(stateUpdate:(state)->state){
        _uiState.update (stateUpdate)
    }
    protected fun getUptState():state=_uiState.value
}