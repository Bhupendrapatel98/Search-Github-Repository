package com.app.taskteachminapplication.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.app.taskteachminapplication.data.model.RepositoryItem
import com.app.taskteachminapplication.ui.home.HomeScreen
import com.app.taskteachminapplication.ui.repositorydetails.ComposeWebView
import com.app.taskteachminapplication.ui.repositorydetails.RepositoryDetailsScreen
import com.google.gson.Gson

@Composable
fun NavGraph(navHostController: NavHostController) {
    NavHost(navController = navHostController, startDestination = MainDestinations.HOME_ROUTE) {
        composable(route=MainDestinations.HOME_ROUTE){
            HomeScreen(navHostController)
        }
        composable(route="${MainDestinations.REPOSITORY_DETAILS_ROUTE}/{jsonString}"){backStackEntry->
            val jsonString: String? = backStackEntry.arguments?.getString("jsonString")
            val user: RepositoryItem? = Gson().fromJson(jsonString, RepositoryItem::class.java)
            user?.let { it1 -> RepositoryDetailsScreen(it1,navHostController) }
        }
        composable(route = "${MainDestinations.WEB_VIEW_ROUTE}/{url}") {backStackEntry ->
            val url: String? = backStackEntry.arguments?.getString("url")
            ComposeWebView(url.toString())
        }
    }
}