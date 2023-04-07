package com.example.spacesweet.ui.welcome

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.spacesweet.R

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun WelcomeScreen(navController: NavHostController){
    //Box es una cajita generica se utiliza para sobreponer elementos
    Scaffold {
        Box(
            Modifier.fillMaxSize()
        ) {
            Box(
                Modifier
                    .background(
                        Brush.verticalGradient(
                            colors = listOf(
                                Color(0xFF242424),
                                Color(0xFF2B2A6D),
                                Color(0xFF000000)
                            ),
                            startY = 0f,
                            endY = Float.POSITIVE_INFINITY
                        )
                    )
                    .fillMaxSize()
            )
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
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
                        modifier = Modifier.fillMaxWidth().padding(30.dp)
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.astronaut),
                            contentDescription = "My Image",
                            modifier = Modifier.size(128.dp).padding(bottom = 30.dp)
                        )
                        Text(
                            text = "Bienvenido, viajero. Vamos a empezar nuestro viaje de productividad por el universo. A continuación vamos a escoger tu meta diaria.",
                            textAlign = TextAlign.Center,
                            modifier = Modifier.padding(bottom = 30.dp)
                        )
                        Button(onClick = { navController.navigate("home")},
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Text(text = "Cerrar",)
                        }
                    }
                }
            }
        }
    }
}