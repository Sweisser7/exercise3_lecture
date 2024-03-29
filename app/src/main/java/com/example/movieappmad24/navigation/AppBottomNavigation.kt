package com.example.movieappmad24.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState

@Composable
fun AppBottomNavigation(navController: NavController) {
    val currentRoute = navController.currentBackStackEntryAsState().value?.destination?.route
    NavigationBar {
        NavigationBarItem(
            icon = { Icon(Icons.Filled.Home, "Home") },
            label = { Text("Home") },
            selected = currentRoute == Screen.HomeScreen.route,
            onClick = {
                if (currentRoute != Screen.HomeScreen.route) {
                    navController.navigate(Screen.HomeScreen.route) {
                        popUpTo(navController.graph.startDestinationId)
                        launchSingleTop = true
                    }
                }
            }
        )
        NavigationBarItem(
            icon = { Icon(Icons.Filled.Star, "Watchlist") },
            label = { Text("Watchlist") },
            selected = currentRoute == Screen.WatchlistScreen.route,
            onClick = {
                if (currentRoute != Screen.WatchlistScreen.route) {
                    navController.navigate(Screen.WatchlistScreen.route) {
                        popUpTo(navController.graph.startDestinationId)
                        launchSingleTop = true
                    }
                }
            }
        )
    }
}