package com.example.lafyufigmatraining2.screen.details

import android.R.attr.contentDescription
import android.R.attr.fontFamily
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.lafyufigmatraining2.R
import com.example.lafyufigmatraining2.screen.customComponents.CustomDetailsHeader
import com.example.lafyufigmatraining2.screen.customComponents.ImageSlider
import com.example.lafyufigmatraining2.screen.customComponents.RatingBar
import com.example.lafyufigmatraining2.screen.stateAndEventControl.SingleItemUiState
import com.example.lafyufigmatraining2.ui.theme.BlueFF
import com.example.lafyufigmatraining2.ui.theme.NavalBlue
import com.example.lafyufigmatraining2.ui.theme.SoftGray
import com.example.lafyufigmatraining2.ui.theme.SoftPurple
import com.example.lafyufigmatraining2.ui.theme.poppinBold
import kotlin.collections.filterNotNull
import kotlin.collections.orEmpty

@Composable
fun SingleItemScreen(modifier: Modifier, state: SingleItemUiState,onBackClick:()->Unit,){
    Column() {
        AsyncImage(model = state.product?.images?.get(0),
            contentDescription = null,
            Modifier.fillMaxWidth()
                .height(200.dp)
                .background(Color.Gray.copy(alpha = 0.2f))
        )

        Row(Modifier.fillMaxWidth().wrapContentHeight(),
            horizontalArrangement = Arrangement.spacedBy(10.dp)) {
            val images = state.product?.images.orEmpty().filterNotNull()
            repeat(images.size){
                val color=BlueFF
                Row(Modifier.fillMaxWidth().wrapContentHeight(),) {
                    Box(Modifier.size(16.dp)
                        .clip(CircleShape)
                        .background(color)) {

                    }
                }

            }
        }

    }



    LazyColumn(Modifier.fillMaxSize()) {
        stickyHeader {
            CustomDetailsHeader(onBackClick = onBackClick,
                title = state.product?.title,
                secondIcon = R.drawable.search_icon,
                onSecondIconClick = {},
                thirdIcon = R.drawable.more_icon,
                onThirdIconClick = {})
        }
        item {
            Column(Modifier.fillMaxWidth()
                .fillMaxHeight(0.293F)
                ) {




                Row(modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.Top) {
                    Column(Modifier.width(300.dp),
                        verticalArrangement = Arrangement.spacedBy(4.dp)) {
                        Text(text = state.product?.title?:"",
                            Modifier.width(300.dp)
                                .padding(vertical = 4.dp),
                            maxLines = 2,
                            overflow = TextOverflow.Ellipsis,
                            style = TextStyle(
                                fontFamily = poppinBold,
                                fontSize = 20.sp,
                                color = NavalBlue
                            )
                        )
                        RatingBar(state.product?.rating?:0.00)
                        Text(text ="$${state.product?.price}",
                            style= TextStyle(
                                color= BlueFF,
                                fontFamily = poppinBold,
                                fontSize = 20.sp
                            ))

                    }

                    Icon(imageVector = ImageVector.vectorResource(R.drawable.heart_icon),
                        contentDescription = null,
                        Modifier.padding(top = 4.dp),
                        tint = SoftPurple,

                        )
                }
            }
        }
    }


}