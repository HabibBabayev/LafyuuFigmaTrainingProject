package com.example.lafyufigmatraining2.screen.auth

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.example.lafyufigmatraining2.navigation.NavRoute

fun NavGraphBuilder.authNavigation(navController: NavController, modifier: Modifier) {
    composable(route = NavRoute.Login.route) {
        val viewModel: LoginViewModel = hiltViewModel()
        val state by viewModel.uiState.collectAsState()
        LaunchedEffect(state) {
          Log.e("show me","state of login ${state.isLoggedIn}")
        }
        LoginScreen(
            onForgotPassword = {},
            event = viewModel::onEvent,
            state = state,
            onSubmitClick = {
                navController.navigate(NavRoute.Home.route) {
                    popUpTo(route = NavRoute.Login.route, popUpToBuilder = {
                        inclusive = true
                    })
                }
            },
            onSignUpClick = {
                navController.navigate(NavRoute.SignUp.route)
            },
            modifier = modifier
        )
    }
    composable(route = NavRoute.SignUp.route) {
        SignUpScreen(onSignInClick = {
            navController.navigate(route = NavRoute.Login.route)
        }, onSubmitClick = {
            navController.navigate(NavRoute.Home.route) {
                popUpTo(route = NavRoute.SignUp.route, popUpToBuilder = {
                    inclusive = true
                })
            }
        }, modifier = modifier)
    }
}