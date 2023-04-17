package com.example.spacesweet

import android.content.Context
import android.media.MediaPlayer
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.spacesweet.ui.login.ui.LoginScreen
import com.example.spacesweet.ui.login.ui.LoginViewModel
import com.example.spacesweet.ui.onboarding.Onboard
import com.example.spacesweet.ui.theme.SpaceSweetTheme
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.spacesweet.data.shared_preferencences.Preferences
import com.example.spacesweet.ui.home.CountDownViewModel
import com.example.spacesweet.ui.home.HomeScreen
import com.example.spacesweet.ui.navigation.BottomNavigation
import com.example.spacesweet.ui.register.RegisterScreen
import com.example.spacesweet.ui.welcome.WelcomeScreen
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.internal.Contexts.getApplication

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val loginViewModel: LoginViewModel by viewModels()
    private val countDownViewModel: CountDownViewModel by viewModels()
    private val mediaPlayerViewModel: MediaPlayerViewModel by viewModels()

    companion object {
        lateinit var preferences: Preferences
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        preferences = Preferences(applicationContext)

        setContent {
            DisposableEffect(Unit) {
                mediaPlayerViewModel.play(this@MainActivity)

                // Unregister the callback when leaving the screen
                onDispose {
                    mediaPlayerViewModel.pause()
                }
            }

            DisposableEffect(Unit) {
                // Call the play function when entering the screen
                mediaPlayerViewModel.play(this@MainActivity)

                // Unregister the callback when leaving the screen
                onDispose {
                    mediaPlayerViewModel.pause()
                }
            }
            SpaceSweetTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val navController = rememberNavController()
                    NavHost(navController = navController, startDestination = "welcome") {
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
                        composable("home") { HomeScreen(countDownViewModel, preferences) }
                        composable("bottomNavigate"){ BottomNavigation(preferences)}
                    }
                }
            }
        }


    }

    override fun onStop() {
        super.onStop()
        mediaPlayerViewModel.stop()
    }

    override fun onDestroy() {
        super.onDestroy()
        mediaPlayerViewModel.release()
    }

}

class MediaPlayerViewModel : ViewModel() {
    private var mediaPlayer: MediaPlayer? = null

    fun play(context: Context) {
        if (mediaPlayer == null) {
            mediaPlayer = MediaPlayer.create(context, R.raw.background_music)
            mediaPlayer?.isLooping = true
        }

        if (!mediaPlayer!!.isPlaying) {
            mediaPlayer!!.start()
        }
    }

    fun pause() {
        mediaPlayer?.pause()
    }

    fun stop() {
        mediaPlayer?.stop()
    }

    fun release() {
        mediaPlayer?.stop()
        mediaPlayer?.release()
        mediaPlayer = null
    }
}


