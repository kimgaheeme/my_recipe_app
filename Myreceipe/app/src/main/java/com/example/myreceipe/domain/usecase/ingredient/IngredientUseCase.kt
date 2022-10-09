package com.example.myreceipe.domain.usecase.post

data class IngredientUseCase(
    val addIngredient: AddIngredientUseCase,
    val addIngredientUse: AddIngredientUseUseCase,
    val deleteIngredient: DeleteIngredientUseCase
)
