package com.example.myreceipe.data.data_source

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.myreceipe.domain.model.Post

@Database(
    entities = [Post::class],
    version = 1
)


abstract class PostDatabase: RoomDatabase() {
    abstract val PostDao: PostDao
}