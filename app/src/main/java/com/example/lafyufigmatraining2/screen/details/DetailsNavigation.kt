package com.example.lafyufigmatraining2.screen.details

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.lafyufigmatraining2.navigation.NavRoute
import com.example.lafyufigmatraining2.screen.stateAndEventControl.CategoryEvents
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.lafyufigmatraining2.screen.main.HomeViewModel
import com.example.lafyufigmatraining2.screen.stateAndEventControl.CategoryUiState

fun NavGraphBuilder.detailsScreen(navController: NavController, modifier: Modifier){

    composable(route = NavRoute.ProductByCategory.route,
        arguments = listOf(navArgument("category"){

            type= NavType.StringType
        })) {
        val viewModel: CategoryViewModel= hiltViewModel()
        val state=viewModel.uiState.collectAsState()
        val category=it.arguments?.getString("category")?:""
        LaunchedEffect(Unit) {
                viewModel.onEvent(CategoryEvents.GetProducts(category))
        }

        ItemsByCategoryScreen(modifier=modifier,state=state.value, onBackClick ={navController.popBackStack()},category=category )
    }
    composable(route = NavRoute.Category.route) {
     val state= CategoryUiState()
        CategoriesScreen(modifier=modifier,
            onCategoryClick = {category ->
                navController.navigate(route =  NavRoute.ProductByCategory.getCategory(category))
            },
            state=state,
            onBackClick = {navController.popBackStack()}
            )
    }
}