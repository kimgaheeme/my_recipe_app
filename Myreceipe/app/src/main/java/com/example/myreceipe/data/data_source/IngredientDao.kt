package com.example.myreceipe.data.data_source

import androidx.room.*
import com.example.myreceipe.domain.model.Ingredient
import com.example.myreceipe.domain.model.Post
import kotlinx.coroutines.flow.Flow

@Dao
interface IngredientDao {

    @Query("SELECT * FROM ingredient")
    fun getIngredient(): Flow<List<Ingredient>>

    @Query("SELECT * FROM ingredient WHERE name LIKE  :name")
    fun getIngredientByName(name: String): Flow<List<Ingredient>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertIngredient(ingredient: Ingredient)

    @Delete
    suspend fun deleteIngredient(ingredient: Ingredient)
}