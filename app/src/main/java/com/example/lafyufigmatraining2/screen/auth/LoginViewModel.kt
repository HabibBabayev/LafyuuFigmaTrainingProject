package com.example.lafyufigmatraining2.screen.auth

import android.util.Log
import androidx.lifecycle.viewModelScope
import com.example.lafyufigmatraining2.general.BaseViewModel
import com.example.lafyufigmatraining2.general.DataStoreManager
import com.example.lafyufigmatraining2.general.Resource
import com.example.lafyufigmatraining2.repository.AppRepository
import com.example.lafyufigmatraining2.screen.stateAndEventControl.LoginEvents
import com.example.lafyufigmatraining2.screen.stateAndEventControl.LoginUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    val repository: AppRepository,
    private val prefDataStore: DataStoreManager
) :
    BaseViewModel<LoginUiState, LoginEvents>() {
    override val initialState: LoginUiState
        get() = LoginUiState()
    override fun onEvent(event: LoginEvents) {
        when(event){
            is LoginEvents.onLoginAction->{
                getLoggedIn()
            }
            is LoginEvents.onPasswordChange->{
                updateState { it.copy(
                    password = event.password
                ) }
            }
            is LoginEvents.onUsernameChange->{
                updateState { it.copy(
                    username = event.userName
                ) }
            }
        }
    }
    private fun getLoggedIn(){
        viewModelScope.launch {
            val state=getUptState()
            repository.getLogin(state.password,state.username).collect { resource->
                when(resource){
                    is Resource.Loading->{
                        updateState {
                            it.copy(loading = true)
                        }
                    }
                    is Resource.Error->{
                        Log.e("ugursuz",resource.message)
                        updateState { it.copy(
                            error = resource.message,
                            loading = false,
                            isLoggedIn = false
                        ) }
                    }
                    is Resource.Success->{
                        prefDataStore.addToken(resource.data.accessToken)
                        Log.e("ugurlu",resource.data.toString())
                        updateState {
                            it.copy(loading = false,
                                isLoggedIn = true)
                        }
                    }
                }
            }
        }
    }

}