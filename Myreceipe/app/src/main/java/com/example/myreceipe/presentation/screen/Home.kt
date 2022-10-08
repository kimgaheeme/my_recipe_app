package com.example.myreceipe.presentation.screen

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.myreceipe.presentation.util.Screen
import com.example.myreceipe.presentation.viewModel.PostViewModel
import com.example.myreceipe.ui.theme.SdSamlipHopang

@Composable
fun Home(
    navController: NavController
) {

    val viewModel = hiltViewModel<PostViewModel>()
    val state by viewModel.state

    Scaffold(
        floatingActionButton = {
            Button(
                onClick = { navController.navigate(Screen.AddPost.root)},
                shape = CircleShape
            ) {
            Icon(Icons.Filled.Add,"add post page")
        }},
        topBar = {
            Text(
                "나의 레시피",
                fontFamily = SdSamlipHopang,
                fontSize = 30.sp,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 10.dp, vertical = 10.dp)
            )
        }
    ) {

        it
        LazyColumn() {
            items(state.posts) { it ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp)
                        .clickable { navController.navigate("${Screen.PostDetail.root}/${it.id}") }
                ) {
                    Column(
                        modifier = Modifier.padding(horizontal = 16.dp),
                        verticalArrangement = Arrangement.Center
                    ) {
                        Text(it.title, fontSize = 18.sp)
                    }
                }
                Divider(modifier = Modifier.fillMaxWidth())
            }

        }
    }
}