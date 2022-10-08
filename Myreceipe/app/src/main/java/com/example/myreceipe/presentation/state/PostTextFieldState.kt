package com.example.myreceipe.presentation.state

data class PostTextFieldState(
    val text: String = "",
    val hint: String = "",
    val isHintVisible: Boolean = true
)
