package com.example.myreceipe.presentation.state

import com.example.myreceipe.domain.model.Post
import com.example.myreceipe.domain.util.OrderType
import com.example.myreceipe.domain.util.PostOrder

data class PostState(
    val posts : List<Post> = emptyList(),
    val postOrder : PostOrder = PostOrder.Title(OrderType.Descending),
    val isOrderSectionVisible : Boolean = false
)
