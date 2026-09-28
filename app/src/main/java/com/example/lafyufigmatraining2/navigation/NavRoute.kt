package com.example.lafyufigmatraining2.navigation

sealed class NavRoute(val route:String) {
    data object Home: NavRoute("home_screen")
    data object Login: NavRoute("login_screen")
    data object SignUp: NavRoute("signUp_screen")
    data object Splash: NavRoute("splash_screen")
}