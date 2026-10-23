package com.example.lafyufigmatraining2.screen.stateAndEventControl

import com.example.lafyufigmatraining2.R
import com.example.lafyufigmatraining2.model.Product
import com.example.lafyufigmatraining2.navigation.NavRoute
import com.example.lafyufigmatraining2.navigation.NavRoute.Category
import java.util.Locale
class Categories(val icon:Int, val name: String) {

}
data class CategoryUiState(
    val products: List<Product> =emptyList(),
    val progressBar: Boolean=false,
    val error: String="",
    val category: List<Categories> =listOf<Categories>(
        Categories(R.drawable.buauty_icon, "beauty"),
        Categories(R.drawable.fragrance_icon,"fragrances"),
        Categories(R.drawable.furniture_icon,"furniture"),
        Categories(R.drawable.groceries_icon,"groceries"),
        Categories(R.drawable.accessories_icon,"home-decoration"),
        Categories(R.drawable.kitchen_icon,"kitchen-accessories"),
        Categories(R.drawable.laptop_icon,"laptops"),
        Categories(R.drawable.man_shirt,"mens-shirts"),
        Categories(R.drawable.man_shoes2,"mens-shoes"),
        Categories(R.drawable.watch_men,"mens-watches"),
        Categories(R.drawable.accessories_mobile,"mobile-accessories"),
        Categories(R.drawable.motorcycle,"motorcycle"),
        Categories(R.drawable.skin_care,"skin-care"),
        Categories(R.drawable.smartphone,"smartphones"),
        Categories(R.drawable.sport_icon,"sports-accessories"),
        Categories(R.drawable.sunglass_icon,"sunglasses"),
        Categories(R.drawable.tablet_icon,"tablets"),
        Categories(R.drawable.tops_icon,"tops"),
        Categories(R.drawable.vehicle_icon,"vehicle"),
        Categories(R.drawable.woman_bag,"womens-bags"),
        Categories(R.drawable.dress,"womens-dresses"),
        Categories(R.drawable.jewellery_icon,"womens-jewellery"),
        Categories(R.drawable.woman_shoes,"womens-shoes"),
        Categories(R.drawable.watch_women,"womens-watches"))
)
