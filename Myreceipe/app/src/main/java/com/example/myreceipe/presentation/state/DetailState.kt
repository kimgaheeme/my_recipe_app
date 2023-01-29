package com.example.myreceipe.presentation.state

import com.example.myreceipe.domain.model.Post
import com.example.myreceipe.domain.util.OrderType
import com.example.myreceipe.domain.util.PostOrder

data class DetailState(
    val title: String = "",
    val content: String = "",
    val link: String = ""
)
