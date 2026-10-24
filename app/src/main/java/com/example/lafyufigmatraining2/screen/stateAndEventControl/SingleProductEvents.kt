package com.example.lafyufigmatraining2.screen.stateAndEventControl

import com.example.lafyufigmatraining2.model.Product

sealed interface SingleProductEvents {
    data class GetProduct(val id:Int): SingleProductEvents
}