package com.example.myreceipe.data.data_source

import androidx.room.*
import com.example.myreceipe.domain.model.IngredientUse
import com.example.myreceipe.domain.model.Post
import kotlinx.coroutines.flow.Flow

@Dao
interface IngredientUseDao {

    @Query("SELECT * FROM ingredientUse")
    fun getIngredientUse(): Flow<List<IngredientUse>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertIngredientUse(ingredientUse: IngredientUse)

    @Delete
    suspend fun deleteIngredientUse(ingredientUse: IngredientUse)
}