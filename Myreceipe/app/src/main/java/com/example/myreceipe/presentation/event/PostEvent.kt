package com.example.myreceipe.presentation.event

import com.example.myreceipe.domain.model.Post
import com.example.myreceipe.domain.util.PostOrder

sealed class PostEvent {
    data class Order(val postOrder: PostOrder) : PostEvent()
    data class DeletePost(val post: Post) : PostEvent()
    object RestorePost: PostEvent()
    object ToggleOrderSection: PostEvent()
}
