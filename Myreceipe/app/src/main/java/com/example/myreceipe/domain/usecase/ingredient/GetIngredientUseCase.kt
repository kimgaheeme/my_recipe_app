package com.example.myreceipe.domain.usecase.post

import com.example.myreceipe.domain.model.Ingredient
import com.example.myreceipe.domain.model.Post
import com.example.myreceipe.domain.repository.IngredientRepository
import com.example.myreceipe.domain.repository.PostRepository
import com.example.myreceipe.domain.util.IngredientOrder
import com.example.myreceipe.domain.util.OrderType
import com.example.myreceipe.domain.util.PostOrder
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class GetIngredientUseCase(
    private val repository: IngredientRepository
) {
    operator fun invoke(
        ingredientOrder: IngredientOrder = IngredientOrder.Name(OrderType.Ascending)
    ): Flow<List<String>> {
        return repository.getIngredient().map { ingredients ->
            when(ingredientOrder.orderType) {
                is OrderType.Ascending -> {
                    ingredients.sortedBy { it.lowercase() }
                }
                is OrderType.Descending -> {
                    ingredients.sortedByDescending { it.lowercase() }
                }
            }
        }
    }
}