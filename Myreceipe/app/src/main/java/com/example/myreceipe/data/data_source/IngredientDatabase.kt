package com.example.myreceipe.data.data_source

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.myreceipe.domain.model.Ingredient
import com.example.myreceipe.domain.model.IngredientUse
import com.example.myreceipe.domain.model.Post

@Database(
    entities = [Ingredient::class],
    version = 1
)


abstract class IngredientDatabase: RoomDatabase() {
    abstract val IngredientDao: IngredientDao
}