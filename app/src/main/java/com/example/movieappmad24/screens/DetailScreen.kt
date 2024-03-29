package com.example.movieappmad24.screens

import android.graphics.drawable.Icon
import android.icu.text.CaseMap.Title
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.compose.rememberAsyncImagePainter
import com.example.movieappmad24.bars.SimpleTopAppBar
import com.example.movieappmad24.models.Movie
import com.example.movieappmad24.models.getMovies


@Composable
fun DetailScreen(navController: NavController, movieId: String?) {
    val movie = getMovies().find { it.id == movieId }
    Scaffold(
        topBar = {
            SimpleTopAppBar(
                title = { Text(movie?.title ?: "Unknown")},
                navigationIcon = {
                    IconButton(onClick = { navController.navigateUp() }) {
                        Icon(
                            imageVector = Icons.Filled.ArrowBack,
                            contentDescription = "Back"
                        )
                    }
                }
            )
        }
    ) { innerPadding ->
        movie?.let {
            Column(
                modifier = Modifier.padding(innerPadding)
            ) {
                MovieRow(movie = it)
                LazyRow(modifier = Modifier.padding(top = 16.dp)) {
                    items(movie.images) { imageUrl ->
                        Card(
                            modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp),
                            elevation = CardDefaults.cardElevation(5.dp)
                        ) {
                            Image(
                                painter = rememberAsyncImagePainter(imageUrl),
                                contentDescription = "Movie Images",
                                modifier = Modifier.size(200.dp, 250.dp),
                                contentScale = ContentScale.Crop)
                        }
                    }
                }
            }
        } ?: run {
                Text(text = "No Details found", modifier = Modifier.padding(innerPadding))
            }
    }
}