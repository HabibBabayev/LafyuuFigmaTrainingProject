package com.example.lafyufigmatraining2.screen.customComponents

import android.R.attr.contentDescription
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.TransformOrigin
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.lafyufigmatraining2.R
import com.example.lafyufigmatraining2.ui.theme.BlueFF
import com.example.lafyufigmatraining2.ui.theme.SoftPurple
import com.example.lafyufigmatraining2.ui.theme.StarYellow
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.math.absoluteValue
import kotlin.math.min

@Composable
fun RatingBar(rating: Double,
              ){
    Row() {
        for (i in 1..5){
            Icon(imageVector = ImageVector.vectorResource(R.drawable.star_icon),
                contentDescription = null,
                tint = if (i.toDouble()<=rating) StarYellow else Color.Unspecified
            )
        }
    }

}
@Composable
fun ImageSlider(imageList: List<String?>?){

    val images = imageList.orEmpty().filterNotNull()

    if (images.isEmpty()) return
    val pageState= rememberPagerState(pageCount={images.size})
    val coroutineScope=rememberCoroutineScope()
    LaunchedEffect(Unit) {
        while (true){
            delay(5000)
            val nextPage=(pageState.currentPage+1) % images.size
            coroutineScope.launch {
                pageState.animateScrollToPage(nextPage)
            }
        }
    }

//Slider Here
    HorizontalPager(pageState) {page->
        val actualPage=page % images.size
        Card(Modifier.fillMaxWidth()
                .height(300.dp)
                .graphicsLayer {
                    val pageOffSet = pageState.offsetForPager(page)
                    val offSetRight=pageOffSet<0f
                    val deg=105f
                    val interpolated= FastOutSlowInEasing.transform(pageOffSet.absoluteValue)
                    rotationY= min(interpolated * if (offSetRight) deg else -deg, 0f)
                    transformOrigin= TransformOrigin(pivotFractionX = if (offSetRight) 0f else 1f, pivotFractionY = 5f)
                },

        ){
            //Pictures here
            AsyncImage(model = images[actualPage],
                contentDescription = null,
                Modifier.fillMaxWidth()
                    .height(238.dp)
                    .background(Color.Gray.copy(alpha = 0.2f))
            )
            //Image Bar Here
            Row(Modifier.fillMaxWidth().wrapContentHeight()) {

                repeat(images.size){
//                    val color=if ((pageState.currentPage%images.size)==it) BlueFF else Color.White

                    Box(Modifier.size(9.dp)
                        .padding(top = 16.dp)
                        .clip(CircleShape)
                        ) {

                    }
                }
            }
        }
    }
}
@OptIn(ExperimentalFoundationApi::class)
fun PagerState.offsetForPager(page:Int)=(currentPage-page)+currentPageOffsetFraction