package com.example.myreceipe.presentation.screen

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.myreceipe.presentation.component.FilterCheckBox
import com.example.myreceipe.presentation.component.MyBottomSheet
import com.example.myreceipe.presentation.component.SubTitleText
import com.example.myreceipe.presentation.util.Screen
import com.example.myreceipe.presentation.viewModel.PostViewModel
import com.example.myreceipe.ui.theme.*
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun Home(
    navController: NavController
) {

    val viewModel = hiltViewModel<PostViewModel>()
    val state by viewModel.state
    var post by viewModel.post

    val filter by viewModel.filter
    val ingredient by viewModel.ingredient

    val coroutineScope = rememberCoroutineScope()
    val bottomSheetScaffoldState = rememberBottomSheetScaffoldState(
        bottomSheetState = BottomSheetState(BottomSheetValue.Collapsed)
    )

    BottomSheetScaffold(
        scaffoldState = bottomSheetScaffoldState,
        floatingActionButton = {
            Button(
                onClick = { navController.navigate(Screen.AddPost.root)},
                shape = CircleShape
            ) {
            Icon(Icons.Filled.Add,"add post page")
        }},
        sheetGesturesEnabled = false,
        sheetShape = RoundedCornerShape(topStart = 12.dp, topEnd = 12.dp),
        sheetPeekHeight = 0.dp,
        sheetContent = {
            MyBottomSheet(
                onCloseClick = {
                    coroutineScope.launch {
                        bottomSheetScaffoldState.bottomSheetState.collapse()
                        viewModel.getPosts()
                    }
                },
                ingredient = ingredient,
                filter = filter,
                deleteIngredient = viewModel::deleteIngredient,
                plusIngredient = viewModel::plusIngredient
            )
        }
    ) {

        LazyColumn() {
            item {
                Row(
                    modifier = Modifier
                        .padding(start = 30.dp, top = 80.dp, bottom = 50.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(Icons.Filled.Menu, "", tint = Gray800)

                    Spacer(modifier = Modifier.size(8.dp))

                    Text(
                        "나의 레시피",
                        fontFamily = SpoqaHanSansNeo,
                        fontWeight = FontWeight.Medium,
                        color = Gray800,
                        fontSize = 25.sp,

                    )


                }

                SubTitleText(text = "Filter")

                LazyRow(
                    horizontalArrangement = Arrangement.spacedBy(5.dp),
                    contentPadding = PaddingValues(horizontal = 30.dp)
                ) {
                    item {
                        Text(
                            "+ 재료 필터추가",
                            fontFamily = SpoqaHanSansNeo,
                            fontWeight = FontWeight.Medium,
                            color = Gray600,
                            fontSize = 15.sp,
                            modifier = Modifier
                                .background(Gray200, RoundedCornerShape(50))
                                .padding(horizontal = 8.dp, vertical = 5.dp)
                                .clickable {
                                    coroutineScope.launch {
                                        bottomSheetScaffoldState.bottomSheetState.expand()
                                    }
                                }

                        )
                    }

                    items(filter) { it ->
                        Text(
                            it,
                            fontFamily = SpoqaHanSansNeo,
                            fontWeight = FontWeight.Medium,
                            color = Gray700,
                            fontSize = 15.sp,
                            modifier = Modifier
                                .background(Yellow200, RoundedCornerShape(50))
                                .padding(horizontal = 8.dp, vertical = 5.dp)

                        )
                    }
                }

                Spacer(modifier = Modifier.size(40.dp))
                
                SubTitleText(text = "Menu")
            }

            items(post) { it ->
                Surface(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable { navController.navigate("${Screen.PostDetail.root}/${it.title}") }
                        .padding(horizontal = 20.dp, vertical = 4.dp),
                    shape = RoundedCornerShape(20.dp)
                ) {
                    Column(
                        modifier = Modifier.padding(horizontal = 20.dp, vertical = 13.dp)
                    ) {
                        Text(it.title, fontSize = 18.sp, )

                        Spacer(modifier = Modifier.size(6.dp))

                        Text(it.content, fontSize = 14.sp, color = Gray500)
                    }
                }
            }

        }
        it
    }

}