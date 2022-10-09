package com.example.myreceipe.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Post(
    @PrimaryKey val title: String,
    val content: String,
    val link: String
) {}

class InvalidPostException(message: String): Exception(message)
