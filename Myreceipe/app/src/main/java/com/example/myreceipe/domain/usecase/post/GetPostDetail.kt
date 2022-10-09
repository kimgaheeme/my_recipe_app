package com.example.myreceipe.domain.usecase.post

import com.example.myreceipe.domain.model.Post
import com.example.myreceipe.domain.repository.PostRepository
import kotlinx.coroutines.flow.Flow

class GetPostDetail(
    private val repository: PostRepository
) {

    suspend operator fun invoke(title: String): Post? {
        return repository.getPostByTitle(title)
    }
}