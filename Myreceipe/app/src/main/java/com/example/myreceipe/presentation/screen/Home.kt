package com.example.myreceipe.presentation.screen

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.myreceipe.presentation.viewModel.PostViewModel

@Composable
fun Home() {

    val viewModel = hiltViewModel<PostViewModel>()
    val state by viewModel.state

    Scaffold(
        floatingActionButton = { Button(onClick = { /*TODO*/ }) {
            Text("+")
        }}
    ) {


        LazyColumn() {
            items(state.posts) { it ->
                Card(modifier = Modifier.fillMaxWidth().height(20.dp)) {
                    Text(it.title)
                }
            }

        }
    }
}