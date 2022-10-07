package com.example.myreceipe.domain.usecase.post

data class IngredientUseCase(
    val getIngredient: GetIngredientUseCase,
    val deleteIngredient: DeleteIngredientUseCase
)
