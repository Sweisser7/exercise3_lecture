package com.example.movieappmad24.bars

import android.graphics.drawable.Icon
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.movieappmad24.navigation.AppBottomNavigation

data class BottomNavigationItem(
    val icon: ImageVector,
    val label: String,
    val route: String,
)
@Composable
fun SimpleBottomAppBar(
    items: List<BottomNavigationItem>,
    currentRoute: String?,
    onItemSelected: (String) -> Unit
) {
    NavigationBar {
        items.forEach { item ->
            NavigationBarItem(
                icon = { Icon(item.icon, contentDescription = item.label) },
                label = { Text(item.label) },
                selected = currentRoute == item.route,
                onClick = {
                    if (currentRoute != item.route) {
                        onItemSelected(item.route)
                    }
                }
            )
        }
    }
}