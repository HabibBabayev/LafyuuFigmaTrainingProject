package com.example.lafyufigmatraining2.navigation

import com.example.lafyufigmatraining2.R
import com.example.lafyufigmatraining2.R.drawable

class Categories(val icon:Int, val name: String) {

}


fun main(){
    val categories=mutableListOf<Categories>()
    categories.add(Categories(R.drawable.man_shirt,"Man Shirt"))
    categories.add(Categories(R.drawable.dress,"Dress"))
    categories.add(Categories(R.drawable.man_bag,"Man Work Equipment"))
    categories.add(Categories(R.drawable.woman_bag,"Woman Bag"))
    categories.add(Categories(R.drawable.man_shoes2,"Man Shoes"))
    categories.add(Categories(R.drawable.man_shoes2,"High Heels"))


}