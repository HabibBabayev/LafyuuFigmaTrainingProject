package com.example.lafyufigmatraining2.screen.auth

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.key
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lafyufigmatraining2.R

import com.example.lafyufigmatraining2.screen.customComponents.CommonMediaButtons
import com.example.lafyufigmatraining2.screen.customComponents.CommonSubmitButton
import com.example.lafyufigmatraining2.screen.customComponents.Divider
import com.example.lafyufigmatraining2.screen.customComponents.LayfuHeader
import com.example.lafyufigmatraining2.screen.customComponents.OutlinedTextFieldSample
import com.example.lafyufigmatraining2.screen.stateAndEventControl.LoginEvents
import com.example.lafyufigmatraining2.screen.stateAndEventControl.LoginUiState
import com.example.lafyufigmatraining2.ui.theme.BlueFF
import com.example.lafyufigmatraining2.ui.theme.poppin
import com.example.lafyufigmatraining2.ui.theme.poppinBold
import com.example.lafyufigmatraining2.ui.theme.poppinLight
import com.example.lafyufigmatraining2.ui.theme.poppinSemiBold

@Composable
fun LoginScreen(onForgotPassword:()->Unit,
                event:(LoginEvents)->Unit,
                state:LoginUiState,
                onSubmitClick:()->Unit,
                onSignUpClick:()->Unit,
                modifier: Modifier){
    LaunchedEffect(state) {
        if (state.isLoggedIn) {
            Log.e("alindi","girdi")
            onSubmitClick()}
        else Log.e("alinmir","girmedi")
    }
//    if (!state.isLoggedIn) Toast.makeText(LocalContext.current,"ugursuz", Toast.LENGTH_LONG).show()

    Box(Modifier.fillMaxSize().padding(horizontal = 16.dp)) {
        Column(modifier.fillMaxWidth()
            .padding(top = 112.dp)
            .align(Alignment.TopCenter),
            horizontalAlignment = Alignment.CenterHorizontally){
            LayfuHeader("Welcome to Lafyuu","Sign in to continue")
            Spacer(Modifier.height(30.dp))
            OutlinedTextFieldSample(icon=R.drawable.envelope_icon, label = "Your Username", text = state.username, onStateChange = {event(
                LoginEvents.onUsernameChange(it))}, keyboardType = KeyboardType.Text)
            Spacer(Modifier.height(10.dp))
            OutlinedTextFieldSample(icon=R.drawable.lock2_icon, label = "Your Password", text = state.password, onStateChange = {event(
                LoginEvents.onPasswordChange(it))}, keyboardType = KeyboardType.Password
            )
            Spacer(Modifier.height(20.dp))
            CommonSubmitButton(submitClick = {event(LoginEvents.onLoginAction)},"Sign In")
            Divider("OR")
            CommonMediaButtons("Facebook", onClick = {}, color = Color.Blue.copy(0.6F), logo = R.drawable.face2_logo)
            Spacer(Modifier.height(10.dp))
            CommonMediaButtons("Google", onClick = {}, color = Color.Unspecified, logo = R.drawable.google_logo_lf)
            TextButton(onClick=onForgotPassword,
                ) {
                Text(text = "Forgot Password?",
                    color = BlueFF,
                    fontSize = 13.sp,
                    fontFamily = poppinSemiBold
                )}
            Row(Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center) {
                Text(text = "Don't have an account?",
                    color = Color.LightGray,
                    fontSize = 13.sp,
                    fontFamily = poppinLight
                )
                TextButton(onClick = onSignUpClick) {
                    Text(text = "Register",
                        fontSize = 13.sp,
                        fontFamily = poppinSemiBold,
                        color=BlueFF)}
            }
        }
    }

}