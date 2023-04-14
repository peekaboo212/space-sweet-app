package com.example.spacesweet

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.spacesweet.ui.login.ui.LoginScreen
import com.example.spacesweet.ui.login.ui.LoginViewModel
import com.example.spacesweet.ui.onboarding.Onboard
import com.example.spacesweet.ui.theme.SpaceSweetTheme
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.spacesweet.ui.home.CountDownViewModel
import com.example.spacesweet.ui.home.HomeScreen
import com.example.spacesweet.ui.navigation.BottomNavigation
import com.example.spacesweet.ui.register.RegisterScreen
import com.example.spacesweet.ui.welcome.WelcomeScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val loginViewModel: LoginViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SpaceSweetTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val navController = rememberNavController()
                    NavHost(navController = navController, startDestination = "onboarding1") {
                        composable("onboarding1") {
                            Onboard(
                                navController,
                                title = "Aumenta tu productividad",
                                image = R.drawable.onboarding1,
                                description = "Con Space Sweet puedes concentarte en tus tareas dejando de la lado las distracciones.",
                                nextRoute = "onboarding2",
                                buttonTitle = "Next",
                            )
                        }
                        composable("onboarding2") {
                            Onboard(
                                navController,
                                title = "Relajación",
                                image = R.drawable.onboarding2,
                                description = "Cautiva tus sentidos con música y animaciones relajantes.",
                                nextRoute = "onboarding3",
                                buttonTitle = "Next",
                            )
                        }
                        composable("onboarding3") {
                            Onboard(
                                navController,
                                title = "Desbloquea planetas",
                                image = R.drawable.onboarding3,
                                description = "Mientras más uses la aplicacion puedes descubir nuevos planetas y aumentar tu nivel.",
                                nextRoute = "login",
                                buttonTitle = "Get Start",
                            )
                        }
                        composable("login") { LoginScreen(loginViewModel, navController) }
                        composable("register") {RegisterScreen(navController)}
                        composable("welcome") { WelcomeScreen(navController)}
                        composable("home") { HomeScreen(CountDownViewModel()) }
                        composable("bottomNavigate"){ BottomNavigation()}
                    }
                }
            }
        }
    }
}

