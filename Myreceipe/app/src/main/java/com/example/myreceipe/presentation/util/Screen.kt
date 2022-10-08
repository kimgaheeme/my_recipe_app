package com.example.myreceipe.presentation.util

sealed class Screen(val root: String) {
    object Home : Screen(root = "home")
    object AddPost : Screen(root = "add_post")
    object PostDetail : Screen(root = "post_detail")
}

sealed class Key(val root: String) {
    object PostDetail : Key(root = "post_detail_id")
}
