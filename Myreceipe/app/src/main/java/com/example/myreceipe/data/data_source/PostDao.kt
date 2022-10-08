package com.example.myreceipe.data.data_source

import androidx.room.*
import com.example.myreceipe.domain.model.Ingredient
import com.example.myreceipe.domain.model.Post
import kotlinx.coroutines.flow.Flow

@Dao
interface PostDao {

    @Query("SELECT * FROM post")
    fun getPost(): Flow<List<Post>>

    @Query("SELECT * FROM post WHERE title LIKE :title")
    fun getPostByTitle(title: String): Flow<List<Post>>

    @Query("SELECT * FROM post WHERE id = :id")
    fun getPostById(id: Int): Post?

    @Query(
        "SELECT * FROM post " +
        "INNER JOIN ingredientUse ON ingredientUse.postId = id " +
        "WHERE ingredientUse.ingredientId IN (:ingredientsId)"
    )
    fun getPostByIngredient(ingredientsId: List<Int>): Flow<List<Post>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPost(post: Post)

    @Delete
    suspend fun deletePost(post: Post)
}