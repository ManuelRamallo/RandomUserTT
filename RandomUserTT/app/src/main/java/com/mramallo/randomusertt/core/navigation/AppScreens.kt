package com.mramallo.randomusertt.core.navigation

sealed class AppScreens(val route: String) {
    object RandomUserScreen: AppScreens("random_user")
    object RandomUserDetailScreen: AppScreens("random_user_detail")
}