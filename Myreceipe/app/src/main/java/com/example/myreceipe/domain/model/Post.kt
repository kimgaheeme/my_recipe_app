package com.example.myreceipe.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Post(
    val title: String,
    val content: String,
    val link: String,
    @PrimaryKey val id: Int? = null
) {}

class InvalidPostException(message: String): Exception(message)
