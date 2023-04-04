package com.example.trotroLive.navigation

sealed class Screen(val route: String) {
    object Welcome : Screen(route = "welcome_screen")
    object Home : Screen(route = "home_screen")

    object Details:Screen(route = "details_screen")
}