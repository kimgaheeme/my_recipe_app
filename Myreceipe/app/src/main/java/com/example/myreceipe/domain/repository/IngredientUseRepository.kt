package com.example.myreceipe.domain.repository

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.myreceipe.domain.model.IngredientUse
import com.example.myreceipe.domain.model.Post
import kotlinx.coroutines.flow.Flow

interface IngredientUseRepository {

    fun getIngredientUse(post: String): Flow<List<IngredientUse>>

    suspend fun insertIngredientUse(ingredientUse: IngredientUse)

    suspend fun deleteIngredientUse(ingredientUse: IngredientUse)
}