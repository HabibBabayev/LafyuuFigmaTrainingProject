package com.example.lafyufigmatraining2.screen.root

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import com.example.lafyufigmatraining2.R
import com.example.lafyufigmatraining2.ui.theme.BlueFF

@Composable
fun SplashScreen(modifier: Modifier){
    Column(Modifier.fillMaxSize()
        .background(BlueFF),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center) {
        Icon(painter = painterResource(R.drawable.lafyuu_white_icon),
            contentDescription = null,
            Modifier.size(72.dp),
            tint = Color.Unspecified)
    }
}