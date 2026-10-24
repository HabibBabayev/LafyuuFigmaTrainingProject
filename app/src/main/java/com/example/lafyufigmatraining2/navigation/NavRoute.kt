package com.example.lafyufigmatraining2.navigation

sealed class NavRoute(val route:String) {
    data object Home: NavRoute("home_screen")
    data object Login: NavRoute("login_screen")
    data object SignUp: NavRoute("signUp_screen")
    data object Splash: NavRoute("splash_screen")
    data object ProductByCategory: NavRoute("categoryProducts_screen/{category}"){
        fun getCategory(category: String)="categoryProducts_screen/$category"
    }
    data object Category: NavRoute("category_screen")
    data object SingleProduct: NavRoute("product/{id}"){
        fun getId(id: Int)="product/$id"
    }
}