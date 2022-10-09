package com.example.myreceipe.domain.usecase.post

import com.example.myreceipe.domain.model.Ingredient
import com.example.myreceipe.domain.model.Post
import com.example.myreceipe.domain.repository.IngredientRepository
import com.example.myreceipe.domain.repository.PostRepository

class AddIngredientUseCase(
    private val repository: IngredientRepository
) {

    suspend operator fun invoke(ingredients: List<String>) {
        return ingredients.forEach { repository.insertIngredient(Ingredient(it)) }
    }
}