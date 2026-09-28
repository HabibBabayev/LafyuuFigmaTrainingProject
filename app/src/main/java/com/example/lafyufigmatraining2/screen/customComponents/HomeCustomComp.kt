package com.example.lafyufigmatraining2.screen.customComponents

import android.R.attr.contentDescription
import android.R.attr.fontFamily
import android.R.attr.maxWidth
import android.R.attr.text
import android.icu.util.TimeUnit
import android.util.Log.i
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemColors
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableLongStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.LineBreak
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.compose.currentBackStackEntryAsState

import com.example.lafyufigmatraining2.R
import com.example.lafyufigmatraining2.navigation.Categories
import com.example.lafyufigmatraining2.navigation.NavBarScreen
import com.example.lafyufigmatraining2.ui.theme.BlueFF
import com.example.lafyufigmatraining2.ui.theme.NavalBlue
import com.example.lafyufigmatraining2.ui.theme.PrimaryRed
import com.example.lafyufigmatraining2.ui.theme.SoftGray
import com.example.lafyufigmatraining2.ui.theme.SoftPurple
import com.example.lafyufigmatraining2.ui.theme.poppinBold
import com.example.lafyufigmatraining2.ui.theme.poppinLight
import com.example.lafyufigmatraining2.ui.theme.poppinNormal
import com.example.lafyufigmatraining2.ui.theme.poppinSemiBold

import kotlinx.coroutines.delay
import java.util.Timer


@Composable
fun CardViewTimer(modifier: Modifier){
    var currentSeconds by remember {
        mutableIntStateOf(10)
    }
    var currentMinutes by remember {
        mutableIntStateOf(1)
    }
    var currentHours by remember {
        mutableIntStateOf(8)
    }
    var timeRuns by remember {
        mutableStateOf(true)
    }
    LaunchedEffect(Unit) {
        while (timeRuns){

            if (currentMinutes>=0 && currentHours>=0 && currentSeconds>=0){

                while (currentSeconds>=0){
                    delay(1000)
                    currentSeconds--
                    when(currentSeconds){
                        0->{
                            delay(1000)
                            currentMinutes--
                            currentSeconds=59


                        }

                }


                }


            } else timeRuns=false
        }

    }

Box(Modifier.fillMaxWidth().height(240.dp)
    ) {

    Image(painter = painterResource(R.drawable.timer_image),
        contentDescription = null,
        Modifier.fillMaxSize()
        )
    Column(Modifier.fillMaxHeight().padding(start = 24.dp),
        verticalArrangement =Arrangement.SpaceAround) {
        Text(text = "Super Flash Sale  50% Off",
          Modifier.width(250.dp),
            style = TextStyle(
                color = Color.White,
                fontSize = 24.sp,
                fontFamily = poppinBold,
                lineHeight = 36.sp
            ),
            overflow = TextOverflow.Clip)
        Row(Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(5.dp),
            verticalAlignment = Alignment.CenterVertically){
            Column(Modifier.background(Color.White, shape = RoundedCornerShape(5.dp))
                .size(width = 42.dp, height = 41.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(text = currentHours.toString(),
                    Modifier.padding(5.dp),
                    style = TextStyle(
                        fontFamily = poppinBold,
                        letterSpacing = 0.5.sp,
                        color = Color.Black,
                        fontSize = 16.sp,
                        lineHeight = 24.sp
                    )
                )
            }

            Text(text = ":",
                style = TextStyle(
                    fontFamily = poppinBold,
                    letterSpacing = 0.5.sp,
                    color = Color.White
                )
            )
            Column(Modifier.background(Color.White, shape = RoundedCornerShape(5.dp))
                .size(width = 42.dp, height = 41.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center) {
                Text(text = currentMinutes.toString(),
                    Modifier.padding(5.dp),
                    style = TextStyle(
                        fontFamily = poppinBold,
                        letterSpacing = 0.5.sp,
                        color = Color.Black,
                        fontSize = 16.sp,
                        lineHeight = 24.sp
                    ),

                )
            }

            Text(text = ":",
                style = TextStyle(
                    fontFamily = poppinBold,
                    letterSpacing = 0.5.sp,
                    color = Color.White
                )
            )
            Column(Modifier.background(Color.White, shape = RoundedCornerShape(5.dp))
                .size(width = 42.dp, height = 41.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center) {
                Text(text = currentSeconds.toString(),
                    Modifier.padding(5.dp),
                    style = TextStyle(
                        fontFamily = poppinBold,
                        letterSpacing = 0.5.sp,
                        color = Color.Black,
                        fontSize = 16.sp,
                        lineHeight = 24.sp
                    )
                )
            }
        }
    }
}
        }
@Composable
fun NavBarScreen(navController: NavController,items:List<NavBarScreen>){
    val navBackStackEntry=navController.currentBackStackEntryAsState().value?.destination


    NavigationBar(Modifier.fillMaxWidth().padding(top = 20.dp),
        containerColor = Color.White){

        items.forEach {
            item->
            val selection=navBackStackEntry?.hierarchy?.any{it.route==item.route}==true
            NavigationBarItem(selected = selection, onClick = {navController.navigate(item.route){
                popUpTo ( navController.graph.startDestinationId){
                    saveState=true
                }
                launchSingleTop=true
                restoreState=false
            }
            }, icon = {
                Icon(imageVector = ImageVector.vectorResource(item.icon), contentDescription = item.title,
                    tint = SoftPurple)
            },
                label = {Text(text=item.title,
                    color = SoftPurple,
                    style = TextStyle(
                        fontSize = 12.sp,
                        fontFamily = poppinLight,

                    )
                )},
                colors = NavigationBarItemColors(
                    selectedIconColor = BlueFF,
                    selectedTextColor = SoftPurple,
                    selectedIndicatorColor = Color.Unspecified,
                    unselectedIconColor = SoftPurple,
                    unselectedTextColor = SoftPurple,
                    disabledIconColor = SoftPurple,
                    disabledTextColor = SoftPurple
                ),


            )

        }
    }
}
val categories=mutableListOf<Categories>()

@Composable
fun CategoryLazyColumn(categories: List<Categories> ){

Box(Modifier.fillMaxWidth().height(148.dp)) {
    Row(Modifier.fillMaxWidth(),
       horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically) {
        Text(text = "Category",
            style = TextStyle(
                color = NavalBlue,
                fontFamily=poppinBold
            ),

            )
        TextButton(onClick = {},
        ) {
            Text(text = "More Categories",
                style = TextStyle(
                    color = BlueFF,
                    fontFamily=poppinBold
                )
            )
        }
    }

    LazyRow(Modifier.align(Alignment.BottomCenter),
        horizontalArrangement = Arrangement.spacedBy(10.dp),
        verticalAlignment = Alignment.CenterVertically
        ) {
        items(categories){
            category->
            CategoryItem(category)
        }
    }
}
}
@Composable
fun CategoryItem(item:Categories){
    Column(Modifier.size(width = 70.dp, height = 108.dp),
        verticalArrangement = Arrangement.Center) {
        Column(modifier = Modifier.size(70.dp)
            .border(width = 1.dp, SoftGray, shape = RoundedCornerShape(100f)),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
            ) {
            Icon(imageVector = ImageVector.vectorResource(item.icon),
                contentDescription = item.name,
                tint = BlueFF

            )

        }
        Spacer(Modifier.height(8.dp))
        Text(text = item.name,
            Modifier.height(30.dp).fillMaxWidth(),
            style = TextStyle(
                fontSize = 10.sp,
                fontFamily = poppinLight,
                color = SoftPurple,
                textAlign = TextAlign.Center
            ),
            overflow = TextOverflow.Clip
            )

    }
}

@Composable
fun CustomRowProductList(category:List<Categories> ,header: String,detailLink:()->Unit,){
    Box(Modifier.fillMaxWidth().height(285.dp)) {
        Row(Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically) {
            Text(text = header,
                style = TextStyle(
                    color = NavalBlue,
                    fontFamily=poppinBold
                ),

                )
            TextButton(onClick = {detailLink()},
            ) {
                Text(text = "See More",
                    style = TextStyle(
                        color = BlueFF,
                        fontFamily=poppinBold
                    )
                )
            }
        }

        LazyRow(Modifier.align(Alignment.BottomCenter),
            horizontalArrangement = Arrangement.spacedBy(10.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            items(category){
                    category->
                SaleProductItem(category)
            }
        }
    }
}
@Composable
fun SaleProductItem(product: Categories){

        Column(modifier = Modifier.size(width = 141.dp, height = 238.dp)
            .border(width = 1.dp, SoftGray, shape = RoundedCornerShape(5.dp)),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Column(Modifier.fillMaxSize()
                .padding(10.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(5.dp)) {

                Image(painter = painterResource(R.drawable.product_pic),
                    contentDescription = product.name,
                    Modifier.fillMaxWidth()
                        .clip(shape = RoundedCornerShape(5.dp))
                )
                Text(text = product.name,
                    Modifier.fillMaxWidth(),
                    style = TextStyle(
                        fontSize = 12.sp,
                        fontFamily = poppinSemiBold,
                        color = NavalBlue,

                    ),
                    overflow = TextOverflow.Clip,
                    maxLines = 2
                )
                Text(text ="$${product.name}" ,
                    Modifier.fillMaxWidth(),
                    style = TextStyle(
                        fontSize = 12.sp,
                        fontFamily = poppinSemiBold,
                        color = BlueFF,

                        ),
                    overflow = TextOverflow.Clip,
                    maxLines = 1
                )
                Row(Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically) {
                    Text(text = "$534  ",
                        style = TextStyle(
                            color = SoftPurple,
                            fontSize = 10.sp,
                            fontFamily = poppinBold
                        ),
                        textDecoration = TextDecoration.LineThrough
                    )
                    Text(text = "24% Off",
                        style = TextStyle(
                            color = PrimaryRed,
                            fontSize = 10.sp,
                            fontFamily = poppinBold
                        ),

                        )
                }


            }


        }



    }
@Composable
fun RecommendedProduct(){
    Box(Modifier.fillMaxWidth().height(250.dp)) {
        Image(painter = painterResource(R.drawable.recommended),
            contentDescription = null,
            modifier = Modifier.fillMaxSize())
        Column(Modifier.fillMaxWidth()
            .align(Alignment.CenterStart).padding(start = 24.dp)) {
            Text(text = "Recommended \nProduct",
                style = TextStyle(
                    color = Color.White,
                    fontFamily = poppinBold,
                    fontSize = 24.sp
                ),
                overflow = TextOverflow.Clip
            )
            Spacer(Modifier.size(18.dp))
            Text(text = "We recommend the best for you",
                style = TextStyle(
                    color = Color.White,
                    fontFamily = poppinNormal,
                    fontSize = 12.sp
                ))
        }

    }
}
