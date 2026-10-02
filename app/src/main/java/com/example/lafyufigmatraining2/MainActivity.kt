package com.example.lafyufigmatraining2

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.BottomAppBarDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.tooling.preview.Preview
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.lafyufigmatraining2.navigation.NavBarScreen
import com.example.lafyufigmatraining2.navigation.NavGraph
import com.example.lafyufigmatraining2.navigation.NavRoute
import com.example.lafyufigmatraining2.screen.auth.LoginScreen
import com.example.lafyufigmatraining2.screen.auth.SignUpScreen
import com.example.lafyufigmatraining2.screen.customComponents.NavBarScreen
import com.example.lafyufigmatraining2.screen.root.SplashScreen
import com.example.lafyufigmatraining2.ui.theme.LafyuFigmaTraining2Theme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController= rememberNavController()
            LafyuFigmaTraining2Theme {

                val scrollBehavior= BottomAppBarDefaults.exitAlwaysScrollBehavior()
                Scaffold(modifier = Modifier.fillMaxSize()
                    .nestedScroll(scrollBehavior.nestedScrollConnection)
                    .background(Color.White),
                    contentColor = Color.Black,
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
                    NavGraph(Modifier.padding(innerPadding),navController=navController)
                }
            }
        }
    }
}



@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    LafyuFigmaTraining2Theme {

    }
}