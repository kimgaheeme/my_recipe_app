package com.example.myreceipe.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(primaryKeys = arrayOf("postId", "ingredient"))
data class IngredientUse(
    val postId: Int,
    val ingredient: String,
) {}
