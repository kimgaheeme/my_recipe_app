package com.example.myreceipe.presentation.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
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
        Box(
            modifier = Modifier.fillMaxWidth()
        ) {
            Icon(
                Icons.Filled.Close,
                contentDescription = "",
                modifier = Modifier
                    .clickable { onCloseClick() }
                    .padding(16.dp)
            )
            Text("재료 선택", modifier = Modifier.align(Alignment.Center))
        }

        Text(
            "선택한 재료가 포함된 음식만 보여드려요!",
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(6.dp)
        )

        LazyColumn() {
            items(ingredient) {
                FilterCheckBox(
                    text = it,
                    clicked = filter.contains(it),
                    deleteIngredient = deleteIngredient,
                    plusIngredient = plusIngredient
                )
                Divider(Modifier.fillMaxWidth().padding(horizontal = 20.dp))
            }
        }
    }
}