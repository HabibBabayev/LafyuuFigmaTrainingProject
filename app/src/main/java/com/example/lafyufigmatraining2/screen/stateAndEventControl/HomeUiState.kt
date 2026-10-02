package com.example.lafyufigmatraining2.screen.stateAndEventControl

import com.example.lafyufigmatraining2.model.Product
import com.example.lafyufigmatraining2.model.ProductResponseModel

data class HomeUiState(
    val productList:List<Product> =emptyList(),
    val loading: Boolean=false,
    val error: Boolean=false
    )