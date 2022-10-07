package com.example.myreceipe.data.data_source

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.myreceipe.domain.model.Ingredient
import com.example.myreceipe.domain.model.Post
import kotlinx.coroutines.flow.Flow

interface IngredientDao {

    @Query("SELECT * FROM ingredient")
    fun getIngredient(): Flow<List<String>>

    @Query("SELECT * FROM ingredient WHERE name LIKE  :name")
    fun getIngredientByName(name: String): Flow<List<String>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertIngredient(ingredient: Ingredient)

    @Delete
    suspend fun deleteIngredient(ingredient: Ingredient)
}