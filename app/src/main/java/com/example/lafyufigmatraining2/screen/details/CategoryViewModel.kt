package com.example.lafyufigmatraining2.screen.details

import androidx.lifecycle.viewModelScope
import com.example.lafyufigmatraining2.general.BaseViewModel
import com.example.lafyufigmatraining2.general.Resource
import com.example.lafyufigmatraining2.repository.AppRepository
import com.example.lafyufigmatraining2.screen.stateAndEventControl.CategoryEvents
import com.example.lafyufigmatraining2.screen.stateAndEventControl.CategoryUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CategoryViewModel @Inject constructor(
   val repository: AppRepository
): BaseViewModel<CategoryUiState, CategoryEvents>() {
    override fun onEvent(event: CategoryEvents) {
        when (event){
            is CategoryEvents.GetProducts->getProductsByCategory(event.category)
        }
    }
    override val initialState: CategoryUiState
        get() = CategoryUiState()
    private fun getProductsByCategory(category: String){
        viewModelScope.launch {
            repository.getProductsByCategory(category).collect { data->
                when(data){
                    is Resource.Success->{
                        updateState {
                            it.copy(products = data.data,
                                progressBar = false)
                        }
                    }
                    is Resource.Error->{
                        updateState {
                            it.copy(error = data.message,
                                progressBar = false)
                        }
                    }
                    is Resource.Loading->{
                        updateState { it.copy(progressBar = true) }
                    }
            }
        } }
    }
}