package com.example.myreceipe.data.repository

import com.example.myreceipe.data.data_source.IngredientUseDao
import com.example.myreceipe.data.data_source.PostDao
import com.example.myreceipe.domain.model.IngredientUse
import com.example.myreceipe.domain.model.Post
import com.example.myreceipe.domain.repository.IngredientUseRepository
import com.example.myreceipe.domain.repository.PostRepository
import kotlinx.coroutines.flow.Flow

class IngredientUseRepositoryImpl(
    private val dao: IngredientUseDao
    ): IngredientUseRepository {
    override fun getIngredientUse(): Flow<List<IngredientUse>> {
        return dao.getIngredientUse()
    }

    override suspend fun insertIngredientUse(ingredientUse: IngredientUse) {
        return dao.insertIngredientUse(ingredientUse)
    }

    override suspend fun deleteIngredientUse(ingredientUse: IngredientUse) {
        return dao.deleteIngredientUse(ingredientUse)
    }

}