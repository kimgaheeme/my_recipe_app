package com.example.myreceipe.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Ingredient(
    val name: String,
    @PrimaryKey val id: Int? = null
) {}
