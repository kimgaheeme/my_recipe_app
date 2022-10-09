package com.example.myreceipe.domain.usecase.post

import com.example.myreceipe.domain.model.Post
import com.example.myreceipe.domain.repository.PostRepository
import com.example.myreceipe.domain.util.OrderType
import com.example.myreceipe.domain.util.PostOrder
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class GetPostUseCase(
    private val repository: PostRepository
) {
    //기본
    operator fun invoke(
        postOrder: PostOrder = PostOrder.Title(OrderType.Ascending)
    ): Flow<List<Post>> {
        return repository.getPost().map { posts ->
            when(postOrder.orderType) {
                is OrderType.Ascending -> {
                    posts.sortedBy { it.title.lowercase() }
                }
                is OrderType.Descending -> {
                    posts.sortedByDescending { it.title.lowercase() }
                }
            }
        }
    }

    //필터를 위한 것
    operator fun invoke(
        postOrder: PostOrder = PostOrder.Title(OrderType.Ascending),
        ingredients: List<String>
    ): Flow<List<Post>> {
        return repository.getPostByIngredient(ingredients).map { posts ->
            when(postOrder.orderType) {
                is OrderType.Ascending -> {
                    posts.sortedBy { it.title.lowercase() }
                }
                is OrderType.Descending -> {
                    posts.sortedByDescending { it.title.lowercase() }
                }
            }
        }
    }
}