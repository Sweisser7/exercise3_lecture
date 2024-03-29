package com.example.movieappmad24.screens

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.movieappmad24.models.getMovies
import com.example.movieappmad24.navigation.AppBottomNavigation
import com.example.movieappmad24.navigation.Screen


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WatchlistScreen(navController: NavController) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text(text = "Your Watchlist") },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.onPrimaryContainer
                )
            )
        },
        bottomBar = {
            AppBottomNavigation(navController = navController)
        }
    ) { innerPadding ->
        val watchlistMovies = getMovies()
        LazyColumn(modifier = Modifier.padding(innerPadding)) {
            items(watchlistMovies) { movie ->
                MovieRow(movie = movie) {
                    navController.navigate(Screen.DetailScreen.createRoute(movie.id))
                }
            }
        }
    }
}