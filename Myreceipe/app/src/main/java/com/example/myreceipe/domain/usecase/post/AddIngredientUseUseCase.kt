package com.example.myreceipe.domain.usecase.post

import com.example.myreceipe.domain.model.Ingredient
import com.example.myreceipe.domain.model.IngredientUse
import com.example.myreceipe.domain.model.Post
import com.example.myreceipe.domain.repository.IngredientRepository
import com.example.myreceipe.domain.repository.IngredientUseRepository
import com.example.myreceipe.domain.repository.PostRepository

class AddIngredientUseUseCase(
    private val repository: IngredientUseRepository
) {

    suspend operator fun invoke(ingredients: List<String>, id: Int) {
        return ingredients.forEach { repository.insertIngredientUse(IngredientUse(id, it)) }
    }
}