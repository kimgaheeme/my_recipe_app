package com.example.myreceipe.data.repository

import com.example.myreceipe.data.data_source.PostDao
import com.example.myreceipe.domain.model.Post
import com.example.myreceipe.domain.repository.PostRepository
import kotlinx.coroutines.flow.Flow

class PostRepositoryImpl(
    private val dao: PostDao
    ): PostRepository {
    override fun getPost(): Flow<List<Post>> {
        return dao.getPost()
    }

    override fun getPostByTitle(title: String): Flow<List<Post>> {
        return dao.getPostByTitle(title)
    }

    override fun getPostByIngredient(ingredientsId: List<Int>): Flow<List<Post>> {
        return dao.getPostByIngredient(ingredientsId)
    }

    override suspend fun insertPost(post: Post) {
        return dao.insertPost(post)
    }

    override suspend fun deletePost(post: Post) {
        return dao.deletePost(post)
    }
}