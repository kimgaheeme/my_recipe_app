package com.example.myreceipe.domain.usecase.post

import com.example.myreceipe.domain.usecase.post.AddPost

data class PostUseCase(
    val getPost: GetPostUseCase,
    val deletePost: DeletePostUseCase,
    val addPost: AddPost,
    val getPostDetail: GetPostDetail
)
