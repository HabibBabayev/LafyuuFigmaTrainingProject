package com.example.lafyufigmatraining2.screen.stateAndEventControl

data class LoginUiState(
    val isLoggedIn: Boolean=false,
    var username: String="",
    val password: String="",
    val error: String="",
    val loading: Boolean=false,
    val email: String=""
    )