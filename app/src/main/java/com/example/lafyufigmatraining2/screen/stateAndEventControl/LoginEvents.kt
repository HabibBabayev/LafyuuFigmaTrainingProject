package com.example.lafyufigmatraining2.screen.stateAndEventControl

sealed interface LoginEvents {
    data class onPasswordChange(val password: String): LoginEvents
    data class onUsernameChange(val userName: String): LoginEvents
    data object onLoginAction: LoginEvents
}