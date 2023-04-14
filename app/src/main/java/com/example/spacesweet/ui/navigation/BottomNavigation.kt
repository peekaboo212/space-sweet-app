package com.example.spacesweet.ui.navigation

import android.annotation.SuppressLint
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.spacesweet.ui.home.HomeScreen
import com.example.spacesweet.ui.planets.PlanetsScreen
import com.example.spacesweet.ui.profile.ProfileScreen

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun BottomNavigation() {
    val navController = rememberNavController()
    Scaffold(
        bottomBar = {
            BottomNavigation(backgroundColor = Color(0xFFFFFFFF)) {
                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val currentRoute = navBackStackEntry?.destination?.route
                BottomNavigationItem(
                    icon = { Icon(Icons.Default.Home, contentDescription = null, tint = Color(0xFF6D46D7)) },
                    label = { Text(text = "Home", color = Color(0xFF6D46D7)) },
                    selected = currentRoute == "home",
                    onClick = {
                        navController.popBackStack(navController.graph.startDestinationId, false)
                    }
                )
                BottomNavigationItem(
                    icon = { Icon(Icons.Default.LocationOn, contentDescription = null, tint = Color(0xFF6D46D7)) },
                    label = { Text("Planets", color = Color(0xFF6D46D7)) },
                    selected = currentRoute == "planets",
                    onClick = {
                        navController.navigate("planets") {
                            popUpTo(navController.graph.startDestinationId) {
                                saveState = true
                            }
                            launchSingleTop = true
                        }
                    }
                )
                BottomNavigationItem(
                    icon = { Icon(Icons.Default.Person, contentDescription = null, tint = Color(0xFF6D46D7)) },
                    label = { Text("Profile", color = Color(0xFF6D46D7)) },
                    selected = currentRoute == "profile",
                    onClick = {
                        navController.navigate("profile") {
                            popUpTo(navController.graph.startDestinationId) {
                                saveState = true
                            }
                            launchSingleTop = true
                        }
                    }
                )
            }
        }
    ) {
        NavHost(navController = navController, startDestination = "home") {
            composable("home") { HomeScreen() }
            composable("planets") { PlanetsScreen()}
            composable("profile") { ProfileScreen() }
        }
    }
}
