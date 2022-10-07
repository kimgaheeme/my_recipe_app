package com.example.myreceipe.data.data_source

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.myreceipe.domain.model.IngredientUse
import com.example.myreceipe.domain.model.Post

@Database(
    entities = [IngredientUse::class],
    version = 1
)


abstract class IngredientUseDatabase: RoomDatabase() {
    abstract val IngredientUseDao: IngredientUseDao

    companion object {
        const val DATABASE_NAME = "ingredientuse_db"
    }
}