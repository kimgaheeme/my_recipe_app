package com.example.myreceipe.domain.usecase.post

data class PostUseCase(
    val getPost: GetPostUseCase,
    val deletePost: DeletePostUseCase
)
