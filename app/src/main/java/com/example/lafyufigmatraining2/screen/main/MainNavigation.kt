package com.example.lafyufigmatraining2.screen.main

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.BottomAppBarDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.compose.LifecycleEventEffect
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.lafyufigmatraining2.navigation.NavBarScreen
import com.example.lafyufigmatraining2.navigation.NavGraph
import com.example.lafyufigmatraining2.navigation.NavRoute
import com.example.lafyufigmatraining2.screen.customComponents.NavBarScreen
import com.example.lafyufigmatraining2.screen.main.SearchBarViewModel
import com.example.lafyufigmatraining2.screen.stateAndEventControl.CategoryUiState
import com.example.lafyufigmatraining2.screen.stateAndEventControl.HomeEvents

@OptIn(ExperimentalMaterial3Api::class)
fun NavGraphBuilder.homeScreen(navController: NavController, modifier: Modifier){
    composable(route = NavRoute.Home.route) {
val viewmodel: HomeViewModel= hiltViewModel()
        val state by viewmodel.uiState.collectAsStateWithLifecycle()
        val categoryState= CategoryUiState().category
        LaunchedEffect(Unit) {
            viewmodel.onEvent(HomeEvents.GetProduct)
        }


        val searchViewModel: SearchBarViewModel=hiltViewModel()
        val searchState by searchViewModel.uiState.collectAsStateWithLifecycle()
        val query = searchViewModel.textFieldState.text.toString()
        //when homescreen activated it this coroutine starts
        DisposableEffect(Unit) {
            val job=searchViewModel.getUserSearch()
            onDispose { job.cancel() }
        }

        val scrollBehavior= BottomAppBarDefaults.exitAlwaysScrollBehavior()
        Scaffold(modifier = Modifier.fillMaxSize()
            .nestedScroll(scrollBehavior.nestedScrollConnection),
            bottomBar = {
                val items =listOf<NavBarScreen>(
                    NavBarScreen.HomeScreen,
                    NavBarScreen.ExploreScreen,
                    NavBarScreen.CartScreen,
                    NavBarScreen.OfferScreen,
                    NavBarScreen.ProfileScreen
                )
                NavBarScreen(navController=navController,items=items,scrollBehavior=scrollBehavior)
            }
        ) { innerPadding ->
            LifecycleEventEffect(Lifecycle.Event.ON_PAUSE){
                searchViewModel.clearSearchField()

            }
            HomeScreen(modifier=modifier.padding(innerPadding),
                state=state,
                onCategoryClick ={category ->
                    navController.navigate(route =  NavRoute.ProductByCategory.getCategory(category))
            },
                onCategoryScreenClick = {
                    navController.navigate(NavRoute.Category.route)
                },
                onSingleItemClick = {id->
                    navController.navigate(route= NavRoute.SingleProduct.getId(id))
                },
                searchState=searchState,
                searchQuery = query,
                searchViewModel=searchViewModel,
                onSearchedItemClick = {id->
                    navController.navigate(route= NavRoute.SingleProduct.getId(id))
                }
            )
        }



    }
    composable(route = NavBarScreen.ProfileScreen.route){
        ProfileScreen()
    }
}