package com.example.myreceipe.presentation.component

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.myreceipe.domain.model.IngredientUse

@Composable
fun CardIngredient(list: List<IngredientUse>) {
    Surface(
        shape = RoundedCornerShape(30.dp),
        modifier = Modifier.padding(horizontal = 30.dp)
    ) {
        Column(
            modifier = Modifier.padding(20.dp)
        ) {
            list.forEachIndexed { index, ingredientUse ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 5.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(ingredientUse.ingredient)
                    Text(ingredientUse.count)
                }
                if(index != list.lastIndex) {
                    Divider(Modifier.fillMaxWidth().padding(horizontal = 3.dp, vertical = 10.dp))
                }
            }
        }
    }
}