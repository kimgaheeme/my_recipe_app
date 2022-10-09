package com.example.myreceipe.presentation.viewModel

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myreceipe.domain.model.Post
import com.example.myreceipe.domain.usecase.post.IngredientUseCase
import com.example.myreceipe.domain.usecase.post.PostUseCase
import com.example.myreceipe.domain.util.OrderType
import com.example.myreceipe.domain.util.PostOrder
import com.example.myreceipe.presentation.event.PostEvent
import com.example.myreceipe.presentation.state.PostState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class PostViewModel @Inject constructor(
    private val postUseCase: PostUseCase,
    private val ingredientUseCase: IngredientUseCase
) : ViewModel() {

    private val _state = mutableStateOf(PostState())
    val state = _state

    private var getPostsJob: Job? = null

    var filter = mutableStateOf(listOf<String>())
    var post = mutableStateOf(listOf<Post>())
    var ingredient = mutableStateOf(listOf<String>())

    init {
        getPosts()
        getIngredient()
    }

    fun getPosts(postOrder: PostOrder = PostOrder.Title(OrderType.Ascending)) {

        getPostsJob?.cancel()
        if(filter.value.size != 0) {
            getPostsJob = postUseCase.getPost(postOrder, filter.value)
                .onEach { posts ->
                    post.value = posts.distinct()
                }
                .launchIn(viewModelScope)
        } else {
            getPostsJob = postUseCase.getPost(postOrder)
                .onEach { posts ->
                    post.value = posts.distinct()
                }
                .launchIn(viewModelScope)
        }


    }

    private fun getIngredient() {
        ingredientUseCase.getIngredientUseCase().onEach {
            ingredient.value = it
        }.launchIn(viewModelScope)
    }

    fun plusIngredient(ingredient: String) {
        filter.value = filter.value.plus(ingredient)
    }

    fun deleteIngredient(ingredient: String) {
        filter.value = filter.value.filter { it != ingredient }
    }
}