package com.example.lafyufigmatraining2.screen.details
import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextMotion
import androidx.compose.ui.unit.dp
import com.example.lafyufigmatraining2.screen.customComponents.CategoryIconItem
import com.example.lafyufigmatraining2.screen.customComponents.CustomDetailsHeader
import com.example.lafyufigmatraining2.screen.stateAndEventControl.CategoryUiState
import com.example.lafyufigmatraining2.ui.theme.NavalBlue
import com.example.lafyufigmatraining2.ui.theme.poppinBold
@Composable
fun CategoriesScreen(modifier: Modifier,
                     onCategoryClick:(category: String)->Unit,
                     state: CategoryUiState,
                     onBackClick:()-> Unit){
    val intSource = remember{ MutableInteractionSource() }
    val isPressed by intSource.collectIsPressedAsState()
    LazyColumn (modifier = Modifier.fillMaxSize()
        .background(Color.White)) {
        stickyHeader {
            CustomDetailsHeader(onBackClick,"Category",null,{},null,{})

        }
        items(state.category){category->
            TextButton(onClick = {onCategoryClick(category.name)},
                Modifier.fillMaxWidth()
                    .height(56.dp)
            ) {
                Row(Modifier.fillMaxSize(),
                    verticalAlignment = Alignment.CenterVertically) {
                    CategoryIconItem(onCategoryClick,state=category.icon,category)
                    Text(text = category.name,
                        style = TextStyle(
                            color = NavalBlue,
                            textMotion = TextMotion.Animated,
                            fontFamily = poppinBold
                        ))
                }

            }
        }
    }

}

