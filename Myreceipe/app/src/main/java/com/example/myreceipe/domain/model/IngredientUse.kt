package com.example.myreceipe.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(primaryKeys = arrayOf("post", "ingredient"))
data class IngredientUse(
    val post: String,
    val ingredient: String,
    val count: String
) {}

