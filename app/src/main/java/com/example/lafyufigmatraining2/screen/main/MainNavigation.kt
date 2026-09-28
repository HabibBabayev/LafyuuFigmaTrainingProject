package com.example.lafyufigmatraining2.screen.main

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.lafyufigmatraining2.navigation.NavBarScreen
import com.example.lafyufigmatraining2.navigation.NavRoute
import com.example.lafyufigmatraining2.screen.customComponents.NavBarScreen

fun NavGraphBuilder.homeScreen(navController: NavController,modifier: Modifier){
    composable(route = NavRoute.Home.route) {
        Scaffold(modifier=modifier,
            bottomBar = {
                val items =listOf<NavBarScreen>(
                    NavBarScreen.HomeScreen,
                    NavBarScreen.ExploreScreen,
                    NavBarScreen.CartScreen,
                    NavBarScreen.OfferScreen,
                    NavBarScreen.ProfileScreen
                )
                NavBarScreen(navController=navController,items=items)
            }) {
            HomeScreen(Modifier.padding(it))
        }

    }
    composable(route = NavBarScreen.ProfileScreen.route){
        ProfileScreen()
    }
}