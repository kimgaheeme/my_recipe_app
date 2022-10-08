package com.example.myreceipe.data.data_source

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.myreceipe.domain.model.Ingredient
import com.example.myreceipe.domain.model.IngredientUse
import com.example.myreceipe.domain.model.Post

@Database(
    entities = [Post::class, Ingredient::class, IngredientUse::class],
    version = 1
)


abstract class PostDatabase: RoomDatabase() {
    abstract val postDao: PostDao
    abstract val ingredientDao: IngredientDao
    abstract val ingredientUseDao: IngredientUseDao

    companion object {
        const val DATABASE_NAME = "post"
    }
}