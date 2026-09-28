package com.example.lafyufigmatraining2.screen.root

import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.lafyufigmatraining2.navigation.NavGraph
import com.example.lafyufigmatraining2.navigation.NavRoute
import kotlinx.coroutines.delay

fun NavGraphBuilder.splashNavigation(navController: NavController,modifier: Modifier){
    composable(route = NavRoute.Splash.route){
        SplashScreen(modifier=modifier)
        LaunchedEffect(Unit) {
            delay(3000)
            navController.navigate(route = NavRoute.Login.route){
                popUpTo(route = NavRoute.Splash.route, popUpToBuilder = {
                    inclusive=true
                })
            }
        }
    }
}