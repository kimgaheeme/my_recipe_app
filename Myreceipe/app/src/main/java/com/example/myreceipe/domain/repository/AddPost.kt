package com.example.myreceipe.domain.repository

import com.example.myreceipe.domain.model.InvalidPostException
import com.example.myreceipe.domain.model.Post
import com.example.myreceipe.presentation.state.PostState

class AddPost(
    private val repository: PostRepository
) {

    @Throws(InvalidPostException::class)
    suspend operator fun invoke(post: Post) {
        if(post.title.isBlank()) {
            throw InvalidPostException("title is empty")
        }
        if(post.content.isBlank()) {
            throw InvalidPostException("content is empty")
        }
        if(post.link.isBlank()) {
            throw InvalidPostException("link is empty")
        }
        return repository.insertPost(post)
    }
}