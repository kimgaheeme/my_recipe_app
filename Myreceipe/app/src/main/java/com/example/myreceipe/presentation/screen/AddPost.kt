package com.example.myreceipe.presentation.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.myreceipe.domain.repository.AddPost
import com.example.myreceipe.presentation.component.MyTextField
import com.example.myreceipe.presentation.component.SubTitleText
import com.example.myreceipe.presentation.event.AddPostEvent
import com.example.myreceipe.presentation.viewModel.AddViewModel
import com.example.myreceipe.ui.theme.Gray100
import com.example.myreceipe.ui.theme.Yellow600
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
        topBar = {
            Box(
                modifier = Modifier.fillMaxWidth()
            ) {
                Icon(Icons.Default.Close,
                    "close",
                    modifier = Modifier
                        .padding(16.dp)
                        .clickable { navController.navigateUp() }
                )
                Text("나의 레시피 추가하기", modifier = Modifier.align(Alignment.Center))
            }
        },
        bottomBar = {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp)
                    .clickable {  viewModel.onEvent(AddPostEvent.SavePost) }
                    .background(Yellow600, RectangleShape)
            ) {
                Text("작성 완료", modifier = Modifier.align(Alignment.Center))
            }
        },
        scaffoldState = scaffoldState
    ) { innerPadding ->
        Column(
            modifier = Modifier.padding(innerPadding)
        ) {
            LazyColumn() {
                item {
                    //제목
                    SubTitleText(text = "Title",2.dp)
                    MyTextField(
                        value = title.text,
                        onValueChange = { viewModel.onEvent(AddPostEvent.EnteredTitle(it)) },
                        placeholder = "음식을 입력하세요"
                    )
                    Spacer(modifier = Modifier.size(20.dp))

                    //재료
                    SubTitleText(text = "Ingredient", 2.dp)
                    MyTextField(
                        value = ingredient.text,
                        onValueChange = { viewModel.onEvent(AddPostEvent.EnteredIngredient(it)) },
                        placeholder = "재료를 입력하세요"
                    )
                    Spacer(modifier = Modifier.size(20.dp))

                    //콘텐츠
                    SubTitleText(text = "How",2.dp)
                    MyTextField(
                        value = content.text,
                        onValueChange = { viewModel.onEvent(AddPostEvent.EnteredContent(it)) },
                        placeholder = "조리 방법을 입력하세요",
                        modifier = Modifier.height(300.dp)
                    )
                    Spacer(modifier = Modifier.size(20.dp))



                    //링크
                    SubTitleText(text = "Link", 2.dp)
                    MyTextField(
                        value = link.text,
                        onValueChange = {  viewModel.onEvent(AddPostEvent.EnteredLink(it)) },
                        placeholder = "참고링크를 입력하세요"
                    )
                    Spacer(modifier = Modifier.size(20.dp))
                }
            }

        }
    }
    
}