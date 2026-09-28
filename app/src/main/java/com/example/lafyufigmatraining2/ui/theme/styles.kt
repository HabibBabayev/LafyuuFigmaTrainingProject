package com.example.lafyufigmatraining2.ui.theme

import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.ShapeDefaults
import androidx.compose.material3.TextFieldColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import com.example.lafyufigmatraining2.ui.theme.BlueFF

val outlinedTextFieldFont=TextStyle(color = Color.Gray.copy(0.8F), fontFamily = poppin, fontWeight = FontWeight.Normal)
val focusedTextFieldFont=TextStyle(color = Color.Gray, fontFamily = poppin, fontWeight = FontWeight.Bold)

@Composable
fun outlinedTextFieldFocusedBorders(): TextFieldColors{

    val outlinedTextFieldFocusedBorders=OutlinedTextFieldDefaults.colors(
        focusedTextColor = Color.DarkGray,
        focusedBorderColor = BlueFF,
        unfocusedBorderColor = Color.Gray.copy(0.24F),
        focusedPlaceholderColor = Color.Transparent,
        cursorColor = Color.Gray,
        unfocusedPlaceholderColor = Color.LightGray,
        focusedLeadingIconColor = BlueFF,
        disabledLeadingIconColor = Color.Gray,
        unfocusedLeadingIconColor = Color.Gray,
        errorBorderColor = Color.Red,
        errorSupportingTextColor = Color.Red,
        errorLeadingIconColor = Color.Red
        )
    return outlinedTextFieldFocusedBorders
}
val outlinedTextFieldCurves=ShapeDefaults.Small