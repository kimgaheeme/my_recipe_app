package com.example.myreceipe

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.myreceipe.presentation.screen.AddPost
import com.example.myreceipe.presentation.screen.Home
import com.example.myreceipe.presentation.screen.PostDetail
import com.example.myreceipe.presentation.util.Key
import com.example.myreceipe.presentation.util.Screen
import com.example.myreceipe.ui.theme.MyreceipeTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyreceipeTheme {
                val navController = rememberNavController()
                NavHost(
                    navController = navController,
                    startDestination = Screen.Home.root
                ) {
                    composable(route = Screen.Home.root) {
                        Home(navController)
                    }
                    composable(route = Screen.AddPost.root) {
                        AddPost(navController)
                    }
                    composable(route = "${Screen.PostDetail.root}/{${Key.PostDetail.root}}") {
                        PostDetail(navController)
                    }
                }
            }
        }
    }
}
