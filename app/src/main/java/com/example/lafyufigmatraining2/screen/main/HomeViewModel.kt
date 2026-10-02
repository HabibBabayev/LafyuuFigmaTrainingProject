package com.example.lafyufigmatraining2.screen.main

import android.util.Log
import androidx.lifecycle.viewModelScope
import com.example.lafyufigmatraining2.general.BaseViewModel
import com.example.lafyufigmatraining2.general.Resource
import com.example.lafyufigmatraining2.repository.AppRepository
import com.example.lafyufigmatraining2.screen.stateAndEventControl.HomeEvents
import com.example.lafyufigmatraining2.screen.stateAndEventControl.HomeUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    val repository: AppRepository
): BaseViewModel<HomeUiState, HomeEvents>() {
    override fun onEvent(event: HomeEvents) {
        when(event){
            is HomeEvents.GetProduct->{
                getProducts()
            }
        }
    }

    override val initialState: HomeUiState
        get() = HomeUiState()

    private fun getProducts(){
        viewModelScope.launch {
            repository.getProducts().collect {resource->
                when(resource){
                   is Resource.Success->{
                       Log.e("sehvlik",resource.data.toString())
                        updateState { state ->
                            state.copy(productList =resource.data.products,
                                loading = false,
                                error = false)
                        }
                    }

                  is  Resource.Loading->{
                      updateState { state->
                          state.copy(loading = true,
                              error = false)
                      }
                  }
                   is Resource.Error->{
                       Log.e("sehvlik",resource.message)
                       updateState { state->
                           state.copy(error = true,
                               loading = false)
                       }
                    }
                }
            }
        }
    }
}