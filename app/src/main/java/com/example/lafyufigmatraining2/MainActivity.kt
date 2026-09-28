package com.example.lafyufigmatraining2

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
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
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LafyuFigmaTraining2Theme {
                Scaffold(modifier = Modifier.fillMaxSize().background(Color.White),
                    bottomBar = {

                    }
                ) { innerPadding ->
                    NavGraph(Modifier.padding(innerPadding))
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