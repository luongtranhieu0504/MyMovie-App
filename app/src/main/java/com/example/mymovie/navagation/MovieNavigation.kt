package com.example.mymovie.navagation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType

import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.mymovie.screens.homes.home.HomeScreen
import com.example.mymovie.screens.homes.details.DetailScreen


@Composable
fun MovieNavigation() {
    var navController = rememberNavController()
    NavHost(navController = navController,
        startDestination =  MovieScreen.HomeScreens.name ){
            composable(MovieScreen.HomeScreens.name) {
                HomeScreen(navController = navController)
            }

            composable(MovieScreen.DetailScreen.name+"/{movie}",
                        arguments = listOf(navArgument(name = "movie")
                        {type = NavType.StringType})){
                backStackEntry->
                DetailScreen(navController = navController,
                    backStackEntry.arguments?.getString("movie"))
            }
        
        }
}
