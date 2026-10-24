package com.example.lafyufigmatraining2.screen.details

import android.util.Log.i
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.lafyufigmatraining2.general.BaseViewModel
import com.example.lafyufigmatraining2.general.Resource
import com.example.lafyufigmatraining2.repository.AppRepository
import com.example.lafyufigmatraining2.screen.stateAndEventControl.SingleItemUiState
import com.example.lafyufigmatraining2.screen.stateAndEventControl.SingleProductEvents
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject
@HiltViewModel
class SingleItemViewModel @Inject constructor(
    val repository: AppRepository
) : BaseViewModel<SingleItemUiState, SingleProductEvents>() {

    override val initialState: SingleItemUiState
        get() = SingleItemUiState()

    override fun onEvent(event: SingleProductEvents) {
        when(event) {
            is SingleProductEvents.GetProduct->{
                getSingleProduct(event.id)
            }
        }
    }
    private fun getSingleProduct(id: Int){
        viewModelScope.launch {
            repository.getSingleProduct(id).collect { item->
                when(item){
                    is Resource.Success->{
                        updateState {
                            it.copy(
                                product=item.data,
                                loading = false,
                                success = true
                            )
                        }
                    }
                    is Resource.Error->{
                        updateState {
                            it.copy(
                                errorMessage = item.message,
                                loading = false,
                                success = false
                            )

                        }
                    }
                    is Resource.Loading->{
                        updateState {
                            it.copy(
                                loading = true,
                                success = false
                            )
                        }
                    }
                }
            }
        }
    }
}