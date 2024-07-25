package com.mramallo.randomusertt.core.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.mramallo.randomusertt.ui.randomUser.RandomUser
import com.mramallo.randomusertt.ui.randomUserDetail.RandomUserDetail

@Composable
fun AppNavigation(){
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = AppScreens.RandomUserScreen.route)
    {
        composable(route = AppScreens.RandomUserScreen.route){
            RandomUser(
                navController = navController
            )
        }
        composable(route = AppScreens.RandomUserDetailScreen.route){
            RandomUserDetail(
                navController = navController
            )
        }
    }
}