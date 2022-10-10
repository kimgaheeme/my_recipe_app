package com.example.myreceipe.domain.usecase.ingredient

import com.example.myreceipe.domain.model.IngredientUse
import com.example.myreceipe.domain.repository.IngredientRepository
import com.example.myreceipe.domain.repository.IngredientUseRepository
import com.example.myreceipe.domain.util.IngredientOrder
import com.example.myreceipe.domain.util.OrderType
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class IngredientUseUseCase(
    private val repository: IngredientUseRepository
) {
    operator fun invoke(
        post: String,
        ingredientOrder: IngredientOrder = IngredientOrder.Name(OrderType.Ascending)
    ): Flow<List<IngredientUse>> {
        return repository.getIngredientUse(post)

    }
}