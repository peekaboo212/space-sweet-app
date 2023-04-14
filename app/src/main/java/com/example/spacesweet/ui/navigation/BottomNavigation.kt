package com.example.spacesweet.ui.navigation

import android.annotation.SuppressLint
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.spacesweet.ui.home.CountDownViewModel
import com.example.spacesweet.ui.home.HomeScreen
import com.example.spacesweet.ui.planets.PlanetsScreen
import com.example.spacesweet.ui.profile.ProfileScreen
import androidx.lifecycle.viewmodel.compose.viewModel as rememberViewModel

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun BottomNavigation() {
    val countDownViewModel: CountDownViewModel = rememberViewModel()

    val navController = rememberNavController()
    Scaffold(
        bottomBar = {
            BottomNavigation {
                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val currentRoute = navBackStackEntry?.destination?.route
                BottomNavigationItem(
                    icon = { Icon(Icons.Default.Home, contentDescription = null) },
                    label = { Text(text = "Home") },
                    selected = currentRoute == "home",
                    onClick = {
                        navController.popBackStack(navController.graph.startDestinationId, false)
                    }
                )
                BottomNavigationItem(
                    icon = { Icon(Icons.Default.LocationOn, contentDescription = null) },
                    label = { Text("Planets") },
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
                    icon = { Icon(Icons.Default.Person, contentDescription = null) },
                    label = { Text("Profile") },
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
            composable("home") { HomeScreen(countDownViewModel) }
            composable("planets") { PlanetsScreen()}
            composable("profile") { ProfileScreen() }
        }
    }
}
