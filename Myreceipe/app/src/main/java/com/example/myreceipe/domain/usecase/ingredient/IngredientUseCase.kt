package com.example.myreceipe.domain.usecase.post

import com.example.myreceipe.domain.usecase.ingredient.IngredientUseUseCase

data class IngredientUseCase(
    val addIngredient: AddIngredientUseCase,
    val addIngredientUse: AddIngredientUseUseCase,
    val deleteIngredient: DeleteIngredientUseCase,
    val getIngredientUseCase: GetIngredientUseCase,
    val getIngredientUseUseCase: IngredientUseUseCase
)
