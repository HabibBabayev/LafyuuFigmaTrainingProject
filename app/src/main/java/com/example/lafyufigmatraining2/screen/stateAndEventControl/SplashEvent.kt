package com.example.lafyufigmatraining2.screen.stateAndEventControl

sealed interface SplashEvent {
    data class onLoginCheck(val token:String?): SplashEvent
}