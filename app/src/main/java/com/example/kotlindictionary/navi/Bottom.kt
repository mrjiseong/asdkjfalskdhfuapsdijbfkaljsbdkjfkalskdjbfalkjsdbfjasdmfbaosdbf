package com.example.kotlindictionary.navi

import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.kotlindictionary.coustomtheme.CustomThemeManager

// 하단 바
@Composable
fun BottomNavigationBar(navController: NavController) {

    val destinations = listOf(Screen.DestinationA, Screen.DestinationB)

    BottomNavigation(backgroundColor = CustomThemeManager.colors.navigation) {

        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route

        destinations.forEach { item ->
            BottomNavigationItem(
                icon = { Icon(item.icon, contentDescription = null) },
                label = { Text(text = item.label) },
                selectedContentColor = CustomThemeManager.colors.navigationItem,
                unselectedContentColor = CustomThemeManager.colors.navigationItem,
                selected = currentRoute == item.route,
                onClick = {
                    navController.navigate(item.route) {
                        navController.graph.startDestinationRoute?.let { route ->
                            popUpTo(route) {
                                saveState = true
                            }
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )
        }
    }
}

sealed class Screen(val route: String, val label: String, val icon: ImageVector) {
    object DestinationA : Screen("destinationA", "북마크", Icons.Default.Person)
    object DestinationB : Screen("destinationB", "메뉴", Icons.Default.Menu)
}