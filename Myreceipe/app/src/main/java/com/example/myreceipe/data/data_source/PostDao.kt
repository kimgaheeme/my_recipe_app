package com.example.myreceipe.data.data_source

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.myreceipe.domain.model.Ingredient
import com.example.myreceipe.domain.model.Post
import kotlinx.coroutines.flow.Flow

interface PostDao {

    @Query("SELECT * FROM post")
    fun getPost(): Flow<List<Post>>

    @Query("SELECT * FROM post WHERE title LIKE :title")
    fun getPostByTitle(title: String): Flow<List<Post>>

    @Query(
        "SELECT * FROM post " +
        "INNER JOIN ingredientuse ON ingredientuse.postId = id " +
        "WHERE ingredientuse.ingredientId IN (:ingredientsId)"
    )
    fun getPostByIngredient(ingredientsId: List<Int>): Flow<List<Post>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPost(post: Post)

    @Delete
    suspend fun deletePost(post: Post)
}