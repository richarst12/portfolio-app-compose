package com.example.portfolio_app_compose.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.portfolio_app_compose.presentation.ui.blog.BlogScreen
import com.example.portfolio_app_compose.presentation.ui.home.HomeScreen

@Composable
fun PortfolioAppNavHost(){
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "home"){
        composable("home") {
            HomeScreen(onMediumClick = {
                navController.navigate("blog")
            })
        }
        composable("blog"){
            BlogScreen()
        }
    }
}