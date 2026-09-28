package com.example.lafyufigmatraining2.screen.customComponents

import android.graphics.drawable.Icon
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.FilledTonalIconButton
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.ShapeDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lafyufigmatraining2.R
import com.example.lafyufigmatraining2.navigation.Categories
import com.example.lafyufigmatraining2.ui.theme.BlueFF
import com.example.lafyufigmatraining2.ui.theme.outlinedTextFieldCurves
import com.example.lafyufigmatraining2.ui.theme.outlinedTextFieldFocusedBorders
import com.example.lafyufigmatraining2.ui.theme.poppin
import com.example.lafyufigmatraining2.ui.theme.poppinBold
import com.example.lafyufigmatraining2.ui.theme.poppinLight
import com.example.lafyufigmatraining2.ui.theme.poppinSemiBold
import java.time.format.TextStyle
import kotlin.math.log

@Composable
fun LayfuHeader(header: String,explanation: String){
    Column(horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(5.dp)) {
        Icon(imageVector = ImageVector.vectorResource(R.drawable.lafyu_icon),
            contentDescription = null,
            Modifier.size(72.dp),
            tint = Color.Unspecified
            )
        Text(text = header,
            fontSize = 20.sp,
            fontFamily = poppinBold,
            fontWeight = FontWeight.Bold,
            color = Color.Black)
        Text(text = explanation,
            fontSize = 13.sp,
            color = Color.LightGray,
            fontFamily = poppinLight,
            fontWeight = FontWeight.Normal)
    }
}

@Composable
fun OutlinedTextFieldSample(icon: Int, label: String, text: String, onStateChange:(text: String)-> Unit, keyboardType: KeyboardType){
    val isPasswordVisible by remember { mutableStateOf(false) }
    OutlinedTextField(
        value = text,
        onValueChange = {
            onStateChange(it)
        },
        Modifier.fillMaxWidth(),
        colors = outlinedTextFieldFocusedBorders(),
        leadingIcon = {
            Icon(imageVector = ImageVector.vectorResource(icon)
                ,contentDescription = null,
                )
        },
        placeholder = {Text(label)},
       keyboardOptions = KeyboardOptions(keyboardType= keyboardType),
        visualTransformation = if (keyboardType== KeyboardType.Password) PasswordVisualTransformation() else VisualTransformation.None,
//        supportingText = {Text(text="Oops! Your Password is not correct ")},
        shape = outlinedTextFieldCurves,


    )
}

@Composable
fun CommonSubmitButton(submitClick:()->Unit,text: String){
    FilledTonalButton(
        onClick = submitClick,
        Modifier.fillMaxWidth()
            .height(60.dp)
            .shadow(5.dp, shape = outlinedTextFieldCurves, ambientColor = Color.Unspecified.copy(0.4F)),
        colors = ButtonDefaults.filledTonalButtonColors(
            containerColor = BlueFF,
            contentColor = Color.White
        ),
        shape = outlinedTextFieldCurves,

    ){
        Text(text = text,
            fontFamily = poppinBold,
            )
    }
}
@Composable
fun CommonMediaButtons(name:String,onClick:()->Unit,color:Color,logo:Int){

        FilledTonalButton (onClick = onClick,
            Modifier.height(60.dp)
                .fillMaxWidth(),
            shape = outlinedTextFieldCurves,
            border = BorderStroke(1.dp,Color.Gray.copy(0.24F)),
            colors = ButtonColors(Color.White,
                Color.Black,
                Color.White,
                Color.Black),
            elevation = ButtonDefaults.filledTonalButtonElevation(0.2.dp)

        ) {
            Row(Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically) {
            Icon(painter = painterResource(logo),
                contentDescription = name,
                Modifier.size(24.dp).padding(start = 0.dp),
                tint=color)

            Text(text="Login with $name",
                Modifier.padding(10.dp),
                fontFamily =poppinBold,
                color=Color.Gray,
            )
                Spacer(Modifier.width(30.dp))
        }

}}

@Composable
fun Divider(text: String){

    Row(Modifier.padding(vertical = 20.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        HorizontalDivider(Modifier.weight(0.5f).padding(end = 20.dp), color = Color.LightGray.copy(0.5F))
        Text(
            text = text,
            fontFamily = poppinBold,
            color = Color.Gray,
            fontSize = 15.sp
        )
        HorizontalDivider(Modifier.weight(0.5f).padding(start = 20.dp),color=Color.LightGray.copy(0.5F))

    }
}
