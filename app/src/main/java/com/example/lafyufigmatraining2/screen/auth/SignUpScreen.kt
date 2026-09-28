package com.example.lafyufigmatraining2.screen.auth

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lafyufigmatraining2.R
import com.example.lafyufigmatraining2.screen.customComponents.CommonSubmitButton
import com.example.lafyufigmatraining2.screen.customComponents.LayfuHeader
import com.example.lafyufigmatraining2.screen.customComponents.OutlinedTextFieldSample
import com.example.lafyufigmatraining2.ui.theme.BlueFF
import com.example.lafyufigmatraining2.ui.theme.poppinLight
import com.example.lafyufigmatraining2.ui.theme.poppinSemiBold

@Composable
fun SignUpScreen(onSignInClick:()->Unit,onSubmitClick:()->Unit,modifier: Modifier){
    Box(Modifier.fillMaxSize().padding(horizontal = 16.dp)) {
        Column(modifier.fillMaxWidth()
            .padding(top = 112.dp)
            .align(Alignment.TopCenter),
            horizontalAlignment = Alignment.CenterHorizontally){
            LayfuHeader("Let's Get Started","Create an new account")
            Spacer(Modifier.height(30.dp))
            Column(Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(10.dp)) {
//                OutlinedTextFieldSample(icon=R.drawable.account_icon, label = "Your Fullname", text = "", keyboardType = KeyboardType.Text)
//
//                OutlinedTextFieldSample(icon=R.drawable.envelope_icon, label = "Your Email", text = "", keyboardType = KeyboardType.Email
//                )
//                OutlinedTextFieldSample(icon=R.drawable.lock2_icon, label = "Password", text = "", keyboardType = KeyboardType.Password
//                )
//                OutlinedTextFieldSample(icon=R.drawable.lock2_icon, label = "Password Again", text = "", keyboardType = KeyboardType.Password
//                )
            }

            Spacer(Modifier.height(20.dp))
            CommonSubmitButton(submitClick = onSubmitClick,"Sign Up")

            Row(Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center) {
                Text(text = "Have an account?",
                    color = Color.LightGray,
                    fontSize = 13.sp,
                    fontFamily = poppinLight
                )
                TextButton(onClick = onSignInClick) {
                    Text(text = "Sign In",
                        fontSize = 13.sp,
                        fontFamily = poppinSemiBold,
                        color=BlueFF)}
            }
        }
    }

}