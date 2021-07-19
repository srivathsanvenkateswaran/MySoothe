package com.srivathsanvenkateswaran.mysoothe.utils

sealed class Screen(val route: String) {
    object WelcomeScreen: Screen(route = "welcome")
    object LogInScreen: Screen(route = "login")
    object HomeScreen: Screen(route = "home")
}
