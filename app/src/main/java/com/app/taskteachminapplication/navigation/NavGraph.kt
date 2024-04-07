package com.app.taskteachminapplication.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.app.taskteachminapplication.ui.home.HomeScreen

@Composable
fun NavGraph(navHostController: NavHostController) {
    NavHost(navController = navHostController, startDestination = MainDestinations.HOME_ROUTE) {
        composable(route=MainDestinations.HOME_ROUTE){
            HomeScreen(navHostController)
        }
        composable(route=MainDestinations.REPOSITORY_DETAILS_ROUTE){
            HomeScreen(navHostController)
        }
    }
}