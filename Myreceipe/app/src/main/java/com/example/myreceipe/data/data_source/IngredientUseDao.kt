package com.example.myreceipe.data.data_source

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.myreceipe.domain.model.IngredientUse
import com.example.myreceipe.domain.model.Post
import kotlinx.coroutines.flow.Flow

interface IngredientUseDao {

    @Query("SELECT * FROM ingredientuse")
    fun getIngredientUse(): Flow<List<Post>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertIngredientUse(ingredientUse: IngredientUse)

    @Delete
    suspend fun deleteIngredientUse(ingredientUse: IngredientUse)
}