package com.example.myreceipe.presentation.viewModel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myreceipe.domain.model.Post
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
    private val postUseCase: PostUseCase
) : ViewModel() {

    private val _state = mutableStateOf(PostState())
    val state = _state

    private var recentlyDeletedPost: Post? = null

    private var getPostsJob: Job? = null

    private var filter: List<String> = listOf("감자")

    init {
        getPosts(PostOrder.Title(OrderType.Descending))
    }

    fun onEvent(event : PostEvent) {
        when(event) {
            is PostEvent.Order -> {
                if(state.value.postOrder::class == event.postOrder::class &&
                        state.value.postOrder.orderType == event.postOrder.orderType
                ) {
                    return
                }
                getPosts(event.postOrder)
            }
            is PostEvent.DeletePost -> {
                viewModelScope.launch {
                    postUseCase.deletePost(event.post)
                    recentlyDeletedPost = event.post
                }
            }
            is PostEvent.RestorePost -> {
                viewModelScope.launch {
                    postUseCase.addPost(recentlyDeletedPost ?: return@launch)
                    recentlyDeletedPost = null
                }
            }
            is PostEvent.ToggleOrderSection -> {
                _state.value = state.value.copy(
                    isOrderSectionVisible = !state.value.isOrderSectionVisible
                )
            }
        }
    }

    private fun getPosts(postOrder: PostOrder) {
        getPostsJob?.cancel()
        if(filter.size != 0) {
            getPostsJob = postUseCase.getPost(postOrder, filter)
                .onEach { posts ->
                    _state.value = state.value.copy(
                        posts = posts,
                        postOrder = postOrder
                    )
                }
                .launchIn(viewModelScope)
        } else {
            getPostsJob = postUseCase.getPost(postOrder)
                .onEach { posts ->
                    _state.value = state.value.copy(
                        posts = posts,
                        postOrder = postOrder
                    )
                }
                .launchIn(viewModelScope)
        }
    }
}