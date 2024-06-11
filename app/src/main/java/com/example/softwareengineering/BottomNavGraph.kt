package com.example.softwareengineering

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun BottomNavGraph(
    viewModel: MainViewModel,
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = BottomBarScreen.Home.route
    ) {
        composable(route = BottomBarScreen.Home.route) {
            HomePage()
        }

        composable(route = BottomBarScreen.Quest.route) {
            QuestPage()
        }

        composable(route = BottomBarScreen.Sensor.route) {
            SensorsScreen()
        }

        composable(route = BottomBarScreen.Shop.route) {
            ShopPage()
        }

        composable(route = BottomBarScreen.Profile.route) {
            ProfilePage(viewModel = viewModel)
        }
    }
}