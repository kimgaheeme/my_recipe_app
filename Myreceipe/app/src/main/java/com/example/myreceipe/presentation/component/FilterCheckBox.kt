package com.example.myreceipe.presentation.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Checkbox
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun FilterCheckBox(
    text: String,
    clicked: Boolean,
    deleteIngredient: (String) -> Unit,
    plusIngredient: (String) -> Unit
) {
    var clickedState = remember{mutableStateOf(clicked)}

    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxWidth()
            .clickable {
                if(clickedState.value) { deleteIngredient(text) }
                else { plusIngredient(text) }
                clickedState.value = !clickedState.value
            }
            .padding(vertical = 10.dp, horizontal = 30.dp)
    ) {
        Text(text, fontSize = 16.sp)
        Checkbox(
            checked = clickedState.value,
            onCheckedChange = null
        )
    }
}