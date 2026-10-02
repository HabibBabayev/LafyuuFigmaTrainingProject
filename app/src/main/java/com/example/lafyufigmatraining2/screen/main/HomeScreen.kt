package com.example.lafyufigmatraining2.screen.main

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyGridItemScope
import androidx.compose.foundation.lazy.grid.LazyGridScope
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Icon

import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource

import androidx.compose.ui.unit.dp

import com.example.lafyufigmatraining2.R
import com.example.lafyufigmatraining2.model.Product
import com.example.lafyufigmatraining2.navigation.Categories
import com.example.lafyufigmatraining2.screen.customComponents.CardViewTimer
import com.example.lafyufigmatraining2.screen.customComponents.CategoryLazyColumn
import com.example.lafyufigmatraining2.screen.customComponents.CustomRowProductList
import com.example.lafyufigmatraining2.screen.customComponents.LazyGridColumnItem
import com.example.lafyufigmatraining2.screen.customComponents.RecommendedProduct
import com.example.lafyufigmatraining2.screen.stateAndEventControl.HomeUiState

import com.example.lafyufigmatraining2.ui.theme.BlueFF
import com.example.lafyufigmatraining2.ui.theme.SoftGray

import com.example.lafyufigmatraining2.ui.theme.poppinLight

@Composable
fun HomeScreen(modifier: Modifier,
               state: HomeUiState){

    LaunchedEffect(state) {

    }




    val categories=mutableListOf<Categories>()
    categories.add(Categories(R.drawable.man_shirt,"Man Shirt"))
    categories.add(Categories(R.drawable.dress,"Dress"))
    categories.add(Categories(R.drawable.man_bag,"Man Work Equipment"))
    categories.add(Categories(R.drawable.woman_bag,"Woman Bag"))
    categories.add(Categories(R.drawable.man_shoes2,"Man Shoes"))
    categories.add(Categories(R.drawable.man_shoes2,"High Heels"))
    LazyVerticalGrid(columns = GridCells.Fixed(2),
        modifier = Modifier.fillMaxSize()
            .background(Color.White)) {
        stickyHeader {
            Column(Modifier.fillMaxWidth().background(Color.White).padding(top = 60.dp),
                verticalArrangement = Arrangement.SpaceBetween) {
                Row(Modifier.fillMaxWidth()
                    .padding(horizontal = 16.dp)
                    , verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween) {
                    OutlinedTextField(
                        value="",
                        onValueChange = {},
                        Modifier.border(
                            width = 1.dp,
                            color = SoftGray,
                            shape = RoundedCornerShape(8.dp)
                        )

                            .padding(),
                        placeholder = { Text(text = "Search Product",
                            fontFamily = poppinLight,
                            color = Color.LightGray,
                            softWrap = false
                        ) },
                        leadingIcon = {
                            Icon(imageVector = ImageVector.vectorResource(R.drawable.search_icon),
                                contentDescription = null,
                                Modifier.size(24.dp),
                                tint = Color.Gray,
                            )
                        },
                        colors = OutlinedTextFieldDefaults.colors(
                            focusedBorderColor = SoftGray,
                            unfocusedBorderColor = SoftGray,
                            focusedLeadingIconColor = BlueFF,
                            cursorColor = Color.Gray
                        ),

                        )
                    Icon(imageVector = ImageVector.vectorResource(R.drawable.heart_icon),
                        contentDescription = null,
                        tint = Color.Gray)
                    Icon(imageVector = ImageVector.vectorResource(R.drawable.group),
                        contentDescription = null,
                        tint = Color.Gray)

                }
                HorizontalDivider(Modifier.fillMaxSize().padding(vertical = 15.dp),thickness = 0.5.dp, color = SoftGray)

            }

        }
        item(span ={GridItemSpan(maxLineSpan)} ) {
            Column( Modifier.fillMaxSize()){
                Column(Modifier.fillMaxWidth()) {

            CardViewTimer(modifier=modifier.background(Color.Cyan))
            CategoryLazyColumn(categories = categories)
                    CustomRowProductList(categories,"Flash Sale"){}
                    CustomRowProductList(categories,"Mega Sale"){}
                    RecommendedProduct()
                }

            }
        }
        items(state.productList){product->
            LazyGridColumnItem(product)
        }
    }

}


