package com.example.lafyufigmatraining2.screen.stateAndEventControl

sealed class SearchState {
    data class UserQuery(val query: String): SearchState()
    data object Empty: SearchState()
}