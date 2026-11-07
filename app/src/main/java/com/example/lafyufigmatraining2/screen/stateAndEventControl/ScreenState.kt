package com.example.lafyufigmatraining2.screen.stateAndEventControl

import com.example.lafyufigmatraining2.model.Product
import com.example.lafyufigmatraining2.model.ProductResponseModel

interface ScreenState {
    object Empty: ScreenState
    object Searching: ScreenState
    data class Error(val message: String): ScreenState
    data class Content(
        val userQuery: String,
        val result: List<Product>
    ): ScreenState
}

