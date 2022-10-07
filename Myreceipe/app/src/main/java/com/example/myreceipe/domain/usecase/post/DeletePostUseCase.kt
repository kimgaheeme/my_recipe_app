package com.example.myreceipe.domain.usecase.post

import com.example.myreceipe.domain.model.Post
import com.example.myreceipe.domain.repository.PostRepository

class DeletePostUseCase(
    private val repository: PostRepository
) {

    suspend operator fun invoke(post: Post) {
        return repository.deletePost(post)
    }
}