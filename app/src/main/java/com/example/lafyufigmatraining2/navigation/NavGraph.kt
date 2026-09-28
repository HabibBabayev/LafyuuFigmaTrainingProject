package com.example.lafyufigmatraining2.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHost
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.example.lafyufigmatraining2.screen.auth.authNavigation
import com.example.lafyufigmatraining2.screen.main.homeScreen
import com.example.lafyufigmatraining2.screen.root.splashNavigation

@Composable
fun NavGraph(modifier: Modifier){
    val navController= rememberNavController()

    NavHost(navController=navController, startDestination = NavRoute.Home.route){
        splashNavigation(navController=navController, modifier = modifier)
        authNavigation(navController=navController,modifier=modifier)
        homeScreen(navController=navController,modifier=modifier)
    }
}