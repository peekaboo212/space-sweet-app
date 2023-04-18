package com.example.spacesweet.ui.profile

import android.annotation.SuppressLint
import android.os.Build
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import coil.ImageLoader
import coil.compose.rememberAsyncImagePainter
import coil.decode.GifDecoder
import coil.decode.ImageDecoderDecoder
import com.example.spacesweet.R
import com.example.spacesweet.data.shared_preferencences.Preferences

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun ProfileScreen(preferences: Preferences, navController: NavHostController){
    Scaffold (

     ){
        Box(
            Modifier.fillMaxSize()
        ) {
            SpaceBackground()
            Column(
                modifier = Modifier.fillMaxSize()
            ) {
                Card(
                    shape = RoundedCornerShape(16.dp),
                    elevation = 4.dp,
                    modifier = Modifier.padding(45.dp)
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(30.dp)
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.profile),
                            contentDescription = "My Image",
                            modifier = Modifier
                                .size(128.dp)
                                .padding(bottom = 30.dp)
                        )
                        Text(
                            text = "Username: " + preferences.getName(),
                            textAlign = TextAlign.Center,
                            modifier = Modifier.padding(bottom = 10.dp)
                        )
                    }
                }
                Card(
                    shape = RoundedCornerShape(16.dp),
                    elevation = 4.dp,
                    modifier = Modifier.padding(horizontal = 45.dp)
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(30.dp)
                    ) {
                        Text(
                            text = "Email: " + preferences.getEmail(),
                            modifier = Modifier.padding(bottom = 10.dp)
                        )
                        Text(
                            text = "Objetivo diario: Sin establecer",
                            modifier = Modifier.padding(bottom = 10.dp)
                        )
                        Button(onClick = { navController.navigate("login"); preferences.saveSession(false); },
                            modifier = Modifier.fillMaxWidth(),
                            colors = ButtonDefaults.buttonColors(
                                backgroundColor = Color.Red,
                                contentColor = Color.White

                            )
                        ) {
                            Text(text = "Cerrar sesión",)
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun SpaceBackground() {
    val imageLoader = ImageLoader.Builder(LocalContext.current)
        .components {
            if (Build.VERSION.SDK_INT >= 28) {
                add(ImageDecoderDecoder.Factory())
            } else {
                add(GifDecoder.Factory())
            }
        }
        .build()

    Image(
        painter = rememberAsyncImagePainter(R.drawable.space_background, imageLoader),
        contentDescription = null,
        modifier = Modifier.fillMaxSize()
    )
}