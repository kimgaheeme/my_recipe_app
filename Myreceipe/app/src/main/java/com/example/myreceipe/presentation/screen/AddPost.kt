package com.example.myreceipe.presentation.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.myreceipe.domain.repository.AddPost
import com.example.myreceipe.presentation.event.AddPostEvent
import com.example.myreceipe.presentation.viewModel.AddViewModel
import kotlinx.coroutines.flow.collectLatest

@Composable
fun AddPost(
    navController: NavController
) {

    val viewModel = hiltViewModel<AddViewModel>()
    val title by viewModel.title
    val content by viewModel.content
    val ingredient by viewModel.ingredient
    val link by viewModel.link

    val scaffoldState = rememberScaffoldState()

    LaunchedEffect(key1 = true) {
        viewModel.eventFlow.collectLatest { event ->
            when(event) {
                is AddViewModel.UiEvent.ShowSnackbar -> {
                    scaffoldState.snackbarHostState.showSnackbar(
                        message = event.message
                    )
                }
                is AddViewModel.UiEvent.SavePost -> {
                    navController.navigateUp()
                }
            }
        }
    }
    
    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    viewModel.onEvent(AddPostEvent.SavePost)
                },
                backgroundColor = MaterialTheme.colors.primary
            ) {
                Text("+asdf")
            }
        },
        scaffoldState = scaffoldState
    ) {
        Column {
            //제목
            TextField(
                value = title.text,
                onValueChange = {
                    viewModel.onEvent(AddPostEvent.EnteredTitle(it))
                },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.size(20.dp))

            //콘텐츠
            TextField(
                value = content.text,
                onValueChange = {
                    viewModel.onEvent(AddPostEvent.EnteredContent(it))
                },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.size(20.dp))

            //재료
            TextField(
                value = ingredient.text,
                onValueChange = {
                    viewModel.onEvent(AddPostEvent.EnteredIngredient(it))
                },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.size(20.dp))

            //링크
            TextField(
                value = link.text,
                onValueChange = {
                    viewModel.onEvent(AddPostEvent.EnteredLink(it))
                },
                modifier = Modifier.fillMaxWidth()
            )
            it
        }
    }
    
}