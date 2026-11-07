package com.example.lafyufigmatraining2.screen.main

import androidx.compose.foundation.text.input.TextFieldState
import androidx.compose.foundation.text.input.delete
import androidx.compose.runtime.snapshotFlow
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import coil.util.CoilUtils.result
import com.example.lafyufigmatraining2.general.Resource
import com.example.lafyufigmatraining2.repository.AppRepository
import com.example.lafyufigmatraining2.screen.stateAndEventControl.ScreenState
import com.example.lafyufigmatraining2.screen.stateAndEventControl.SearchState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.mapLatest
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchBarViewModel @Inject constructor(
  private val apiRepository: AppRepository
): ViewModel() {

 val textFieldState= TextFieldState()
    private val _uiState= MutableStateFlow<ScreenState>(ScreenState.Empty)
    val uiState get() = _uiState.asStateFlow()
    @OptIn(FlowPreview::class, ExperimentalCoroutinesApi::class)
    private val searchTextState: StateFlow<SearchState> =
        snapshotFlow { textFieldState.text }//this creates char Sequence flow in SearchState from whatever we type in a textField
        .debounce { 500 }
        .mapLatest { if(it.isBlank()) SearchState.Empty else SearchState.UserQuery(it as String) }
        .stateIn(
            scope= viewModelScope,
            started = SharingStarted.Companion.WhileSubscribed(2000),
            initialValue = SearchState.Empty
        )

    fun getUserSearch()=viewModelScope.launch {
        searchTextState.collect {search->
            when(search){
                is SearchState.Empty->{
                    _uiState.update { ScreenState.Empty }
                }
                is SearchState.UserQuery->{
                     searchAllCharacters(search.query)
                }
            }
        }
        }
    fun clearSearchField(){
        textFieldState.edit { delete(0,length) }
    }

    private suspend fun searchAllCharacters(query: String){
                _uiState.update { ScreenState.Searching }
                apiRepository.getSearchedProduct(query).collect {product->
                    when(product){
                       is Resource.Success->{

                           _uiState.update {screen->
                               val filteredProducts=product.data.filter {
                                   it.title.orEmpty().contains(query,ignoreCase = true)
                               }
                               ScreenState.Content(userQuery = query,
                                   result = filteredProducts)
                           }
                       }
                        is Resource.Error->{

                            _uiState.update {
                                ScreenState.Error(product.message)
                            }
                        }
                        is Resource.Loading->{
                            _uiState.update {
                                delay(2000)
                                ScreenState.Searching

                            }

                        }
                    }
        }
    }

}