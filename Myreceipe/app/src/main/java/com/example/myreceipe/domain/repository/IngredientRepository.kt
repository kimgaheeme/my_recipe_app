package com.example.myreceipe.domain.repository

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.myreceipe.domain.model.Ingredient
import com.example.myreceipe.domain.model.Post
import kotlinx.coroutines.flow.Flow

interface IngredientRepository {

    fun getIngredient(): Flow<List<String>>

    fun getIngredientByName(name: String): Flow<List<Ingredient>>

    suspend fun insertIngredient(ingredient: Ingredient)

    suspend fun deleteIngredient(ingredient: Ingredient)
}