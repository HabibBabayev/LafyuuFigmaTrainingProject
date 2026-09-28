package com.example.lafyufigmatraining2.navigation

import com.example.lafyufigmatraining2.R

sealed class NavBarScreen(val route: String, val title: String, val icon:Int) {
    data object HomeScreen: NavBarScreen("home_screen","Home",R.drawable.home_icon)
    data object ExploreScreen: NavBarScreen("explore","Explore",R.drawable.search1_icon)
    data object CartScreen: NavBarScreen("cart","Cart",R.drawable.cart_icon)
    data object OfferScreen: NavBarScreen("offer","Offer",R.drawable.offer_icon)
    data object ProfileScreen: NavBarScreen("profile","Profile",R.drawable.profile_icon)

}