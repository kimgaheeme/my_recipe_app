package com.example.myreceipe.domain.repository

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.myreceipe.domain.model.Post
import kotlinx.coroutines.flow.Flow

interface PostRepository {

    fun getPost(): Flow<List<Post>>
    fun getPostByTitle(title: String): Flow<List<Post>>
    fun getPostByIngredient(ingredientsId: List<Int>): Flow<List<Post>>

    suspend fun insertPost(post: Post)
    suspend fun deletePost(post: Post)
}