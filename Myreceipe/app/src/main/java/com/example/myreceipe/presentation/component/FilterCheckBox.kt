package com.example.myreceipe.presentation.component

import androidx.compose.foundation.layout.Row
import androidx.compose.material.Checkbox
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.unit.sp

@Composable
fun FilterCheckBox(
    text: String,
    clicked: Boolean,
    deleteIngredient: (String) -> Unit,
    plusIngredient: (String) -> Unit
) {
    var clickedState = remember{mutableStateOf(clicked)}

    Row() {
        Text(text, fontSize = 14.sp)
        Checkbox(
            checked = clickedState.value,
            onCheckedChange = {  it ->
                if(clickedState.value) { deleteIngredient(text) }
                else { plusIngredient(text) }
                clickedState.value = !clickedState.value
            }
        )
    }
}