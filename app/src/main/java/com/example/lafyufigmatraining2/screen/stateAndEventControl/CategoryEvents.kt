package com.example.lafyufigmatraining2.screen.stateAndEventControl

sealed interface CategoryEvents {
    data class GetProducts(val category: String): CategoryEvents
}