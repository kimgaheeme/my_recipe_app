package com.example.myreceipe.presentation.util

sealed class Screen(val root: String) {
    object Home : Screen(root = "home")
    object AddPost : Screen(root = "add_post")
}
