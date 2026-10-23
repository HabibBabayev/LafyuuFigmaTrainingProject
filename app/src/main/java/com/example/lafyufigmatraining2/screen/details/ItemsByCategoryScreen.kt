package com.example.lafyufigmatraining2.screen.details

import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.example.lafyufigmatraining2.screen.customComponents.LazyGridColumnItem
import com.example.lafyufigmatraining2.screen.stateAndEventControl.CategoryUiState
import androidx.compose.ui.Modifier
import com.example.lafyufigmatraining2.R
import com.example.lafyufigmatraining2.screen.customComponents.CustomDetailsHeader

@Composable
fun ItemsByCategoryScreen(modifier: Modifier,state: CategoryUiState,onBackClick:()->Unit,category: String){


    LazyVerticalGrid(columns = GridCells.Fixed(2)) {
        stickyHeader {    CustomDetailsHeader(onBackClick,category,null,{},null,{}) }
        items(state.products){product->

            LazyGridColumnItem(product)
        }
    }
}