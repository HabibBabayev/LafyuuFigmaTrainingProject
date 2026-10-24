package com.example.lafyufigmatraining2.screen.stateAndEventControl

import com.example.lafyufigmatraining2.model.Product

data class SingleItemUiState (
    val product: Product?= null,
    val errorMessage: String="",
    val success: Boolean=false,
    val loading: Boolean=false
)