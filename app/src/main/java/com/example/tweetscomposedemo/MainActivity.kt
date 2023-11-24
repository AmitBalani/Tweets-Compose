package com.example.tweetscomposedemo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.tweetscomposedemo.screens.CategoryScreen
import com.example.tweetscomposedemo.screens.DetailsScreen
import com.example.tweetscomposedemo.ui.theme.TweetsComposeDemoTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TweetsComposeDemoTheme {
                TweetsApp()
            }
        }
    }
}

@Composable
fun TweetsApp() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "category") {
        composable(route = "category") {
            CategoryScreen {
                navController.navigate(route = "details/${it}" )
            }
        }

        composable(
            route = "details/{category}",
            arguments = listOf(navArgument("category") {
                type = NavType.StringType
            })
        ) {
            DetailsScreen()
        }

    }
}