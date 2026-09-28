package com.example.lafyufigmatraining2.screen.root

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.lafyufigmatraining2.general.DataStoreManager
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.compose
import kotlinx.coroutines.launch
import javax.inject.Inject



@HiltViewModel
class SplashViewModel @Inject constructor(
   private val preferences: DataStoreManager
): ViewModel() {

    init {
        loginCheck()
    }


    fun loginCheck(){
        viewModelScope.launch {
            preferences.getToken().collect {
                Log.e("token",it?:"")
            }
        }
    }
}