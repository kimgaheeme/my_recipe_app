package com.example.myreceipe.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class IngredientUse(
    val postId: Int,
    val ingredientId: Int,
) {}
