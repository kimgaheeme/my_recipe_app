package com.example.myreceipe.presentation.screen

import android.view.Surface
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Close
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.myreceipe.presentation.component.CardIngredient
import com.example.myreceipe.presentation.component.SubTitleText
import com.example.myreceipe.presentation.viewModel.DetailViewModel
import com.example.myreceipe.ui.theme.Gray100
import com.example.myreceipe.ui.theme.Yellow050

@Composable
fun PostDetail(
    navController: NavController
) {
    val viewModel = hiltViewModel<DetailViewModel>()
    val post by viewModel.post
    val ingredient by viewModel.ingredient

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Yellow050
    ) {
        Column(
        ) {
            Icon(
                Icons.Filled.ArrowBack,
                contentDescription = "",
                modifier = Modifier
                    .clickable { navController.navigateUp() }
                    .padding(16.dp)
            )

            LazyColumn() {
                item {
                    Text(
                        post.title,
                        style = MaterialTheme.typography.h3,
                        modifier = Modifier.padding(vertical = 50.dp, horizontal = 30.dp)
                    )

                    SubTitleText(text = "재료")
                    CardIngredient(list = ingredient)


                    Spacer(modifier = Modifier.size(30.dp))
                    SubTitleText(text = "조리방법")
                    Surface(
                        modifier = Modifier.fillMaxWidth().padding(horizontal = 30.dp),
                        shape = RoundedCornerShape(30.dp),
                        color = Gray100
                    ) {
                        Text(post.content, modifier = Modifier.padding(16.dp))
                    }
                }
            }


        }
    }

}