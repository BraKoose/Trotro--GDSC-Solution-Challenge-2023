package com.example.trotroLive.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.trotroLive.screen.HomeScreen
import com.example.trotroLive.screen.WelcomeScreen
import com.example.trotroLive.viewmodel.TrotroViewModel
import com.google.accompanist.pager.ExperimentalPagerApi

@ExperimentalAnimationApi
@ExperimentalPagerApi
@Composable
fun SetupNavGraph(
    navController: NavHostController,
    startDestination: String,
    trotroViewModel: TrotroViewModel

) {
    NavHost(
        navController = navController,
        startDestination = startDestination,

    ) {
        composable(route = Screen.Welcome.route) {
            WelcomeScreen(navController = navController)
        }
        composable(route = Screen.Home.route) {
            HomeScreen(
                trotroViewModel = trotroViewModel,
                trotros = trotroViewModel.trotros.value// Pass the trotros LiveData from TrotroViewModel
            )
        }
    }
}
