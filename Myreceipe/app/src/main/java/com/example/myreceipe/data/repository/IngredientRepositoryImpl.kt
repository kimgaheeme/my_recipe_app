package com.example.myreceipe.data.repository

import com.example.myreceipe.data.data_source.IngredientDao
import com.example.myreceipe.data.data_source.PostDao
import com.example.myreceipe.domain.model.Ingredient
import com.example.myreceipe.domain.model.Post
import com.example.myreceipe.domain.repository.IngredientRepository
import com.example.myreceipe.domain.repository.PostRepository
import kotlinx.coroutines.flow.Flow

class IngredientRepositoryImpl(
    private val dao: IngredientDao
    ): IngredientRepository {
    override fun getIngredient(): Flow<List<Ingredient>> {
        return dao.getIngredient()
    }

    override fun getIngredientByName(name: String): Flow<List<Ingredient>> {
        return dao.getIngredientByName(name)
    }

    override suspend fun insertIngredient(ingredient: Ingredient) {
        return dao.insertIngredient(ingredient)
    }

    override suspend fun deleteIngredient(ingredient: Ingredient) {
        return dao.deleteIngredient(ingredient)
    }

}