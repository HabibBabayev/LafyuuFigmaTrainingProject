package com.example.lafyufigmatraining2.general

sealed class Resource<out T> {
    data class Success<T>(val data:T): Resource<T>()
    data class Error(val message: String): Resource<Nothing>()
    data object Loading: Resource<Nothing>()
}