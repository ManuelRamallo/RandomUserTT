package com.mramallo.randomusertt.core.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.mramallo.randomusertt.ui.randomUser.RandomUserScreen
import com.mramallo.randomusertt.ui.randomUserDetail.RandomUserDetailScreen

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = AppScreens.RandomUserScreen.route
    )
    {
        composable(route = AppScreens.RandomUserScreen.route) {
            RandomUserScreen(
                navController = navController
            )
        }
        composable(
            route = AppScreens.RandomUserDetailScreen.route + "/{idUser}",
            arguments = listOf(
                navArgument(name = "idUser") {
                    type = NavType.StringType
                })
        ) {
            RandomUserDetailScreen(
                navController = navController,
                idUser = it.arguments?.getString("idUser")
            )
        }
    }
}