package com.example.myreceipe.domain.usecase.post

import com.example.myreceipe.domain.repository.AddPost

data class PostUseCase(
    val getPost: GetPostUseCase,
    val deletePost: DeletePostUseCase,
    val addPost: AddPost
)
