package com.example.myreceipe.presentation.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.BottomSheetScaffoldState
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun MyBottomSheet(
    onCloseClick: () -> Unit,
    ingredient: List<String>,
    filter: List<String>,
    deleteIngredient: (String) -> Unit,
    plusIngredient: (String) -> Unit
) {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Icon(
            Icons.Filled.Close,
            contentDescription = "",
            modifier = Modifier.clickable {
                onCloseClick()
            })
        ingredient.forEach {
            FilterCheckBox(
                text = it,
                clicked = filter.contains(it),
                deleteIngredient = deleteIngredient,
                plusIngredient = plusIngredient
            )
        }
    }
}