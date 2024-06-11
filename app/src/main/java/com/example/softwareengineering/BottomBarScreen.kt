package com.example.softwareengineering

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.List
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomBarScreen(
    val route: String,
    val title: String,
    val icon: ImageVector
) {
    object Home : BottomBarScreen(
        route = "home",
        title = "Home",
        icon = Icons.Default.Home
    )

    object Quest : BottomBarScreen(
        route = "quest",
        title = "Quest",
        icon = Icons.AutoMirrored.Filled.List
    )

    object Sensor : BottomBarScreen(
        route = "sensor",
        title = "Sensor",
        icon = Icons.Default.Build
    )

    object Shop : BottomBarScreen(
        route = "shop",
        title = "Shop",
        icon = Icons.Default.ShoppingCart
    )

    object Profile : BottomBarScreen(
        route = "profile",
        title = "Profile",
        icon = Icons.Default.Person
    )
}