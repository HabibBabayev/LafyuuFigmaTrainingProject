package com.example.lafyufigmatraining2

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

import androidx.compose.ui.Modifier

import androidx.compose.ui.tooling.preview.Preview

import androidx.navigation.compose.rememberNavController

import com.example.lafyufigmatraining2.navigation.NavGraph

import com.example.lafyufigmatraining2.ui.theme.LafyuFigmaTraining2Theme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()
            LafyuFigmaTraining2Theme {


                Scaffold(
                    modifier = Modifier.fillMaxSize()

                ) { innerPadding ->
                    NavGraph(Modifier.padding(innerPadding), navController = navController)
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