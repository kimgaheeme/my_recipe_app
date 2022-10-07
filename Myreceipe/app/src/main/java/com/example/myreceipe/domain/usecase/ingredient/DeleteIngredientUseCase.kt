package com.example.myreceipe.domain.usecase.post

import com.example.myreceipe.domain.model.Ingredient
import com.example.myreceipe.domain.model.Post
import com.example.myreceipe.domain.repository.IngredientRepository
import com.example.myreceipe.domain.repository.PostRepository

class DeleteIngredientUseCase(
    private val repository: IngredientRepository
) {

    suspend operator fun invoke(ingredient: Ingredient) {
        return repository.deleteIngredient(ingredient)
    }
}