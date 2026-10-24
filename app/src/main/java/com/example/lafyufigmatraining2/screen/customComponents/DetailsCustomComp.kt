package com.example.lafyufigmatraining2.screen.customComponents

import android.R.attr.category
import android.R.attr.contentDescription
import android.R.attr.text
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Indication
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextMotion
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lafyufigmatraining2.R
import com.example.lafyufigmatraining2.screen.stateAndEventControl.Categories
import com.example.lafyufigmatraining2.screen.stateAndEventControl.CategoryUiState
import com.example.lafyufigmatraining2.ui.theme.BlueFF
import com.example.lafyufigmatraining2.ui.theme.NavalBlue
import com.example.lafyufigmatraining2.ui.theme.SoftGray
import com.example.lafyufigmatraining2.ui.theme.SoftPurple
import com.example.lafyufigmatraining2.ui.theme.poppinBold

@Composable
fun CustomDetailsHeader(onBackClick:()->Unit,
                        title: String?,
                        secondIcon:Int?,
                        onSecondIconClick:()->Unit,thirdIcon:Int?,
                        onThirdIconClick:()->Unit){
    Column(Modifier.fillMaxWidth().background(Color.White).padding(top = 60.dp),
        verticalArrangement = Arrangement.SpaceBetween) {
        val intSourceOfBackClick = remember { MutableInteractionSource() }
        val intSourceOfSearchClick = remember { MutableInteractionSource() }
        val intSourceOfMoreClick = remember { MutableInteractionSource() }

        val backClickPressed by intSourceOfBackClick.collectIsPressedAsState()
        val searchClickPressed by intSourceOfSearchClick.collectIsPressedAsState()
        val moreClickPressed by intSourceOfMoreClick.collectIsPressedAsState()

        Row(Modifier.fillMaxWidth()
            .padding(horizontal = 16.dp)
            , verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,

            ) {
            Row() {      Icon(imageVector = ImageVector.vectorResource(R.drawable.back_logo_thicker),
                contentDescription = null,
                Modifier.clickable(enabled = true,
                    interactionSource=intSourceOfBackClick,
                    indication = null
                    ){onBackClick()}
                    .padding(end = 16.dp),
                tint = if (backClickPressed) Color.Black else SoftPurple
            )
                Text(
                    text = title?:"",
                    Modifier.width(219.dp),
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    style = TextStyle(
                        color = NavalBlue,
                        textMotion = TextMotion.Animated,
                        fontSize = 16.sp,
                        fontFamily = poppinBold,
                    ),
                )}
            Row() {
                Icon(imageVector = ImageVector.vectorResource(secondIcon?:R.drawable.search_icon),
                    contentDescription = null,
                    Modifier.clickable(enabled = true,
                        interactionSource=intSourceOfSearchClick,
                        indication = null,
                        onClick = {
                        onSecondIconClick()
                    }).padding(end = 16.dp),
                    tint = if (secondIcon==null) Color.Transparent else {
                        if (searchClickPressed) Color.Black else SoftPurple
                    })
                Icon(imageVector = ImageVector.vectorResource(thirdIcon?:R.drawable.more_icon),
                    contentDescription = null,
                    Modifier.clickable(enabled = true,
                        interactionSource=intSourceOfMoreClick,
                        indication = null,
                        onClick = {
                        onThirdIconClick()
                    })
                        .padding(end = 16.dp),
                    tint = if (thirdIcon==null) Color.Transparent else {
                        if (moreClickPressed) Color.Black else SoftPurple
                    })
            }
        }

        HorizontalDivider(Modifier.fillMaxSize().padding(vertical = 15.dp),thickness = 0.5.dp, color = SoftGray)
    }
}
@Composable
fun CategoryIconItem(onCategoryClick:(category: String)->Unit,
                     state: Int,
                    category: Categories){
    val intSource = remember{ MutableInteractionSource() }
    val isPressed by intSource.collectIsPressedAsState()
    Icon(imageVector = ImageVector.vectorResource(state),
        contentDescription = null,
        Modifier.padding(end = 16.dp)
            .clickable(enabled = true,
                interactionSource = intSource,
                indication = null){
                onCategoryClick(category.name)},
        tint = if (isPressed) Color.Unspecified else BlueFF,)
}