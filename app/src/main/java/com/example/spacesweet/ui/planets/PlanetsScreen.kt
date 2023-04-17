package com.example.spacesweet.ui.planets

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.spacesweet.R

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun PlanetsScreen(){
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
                    modifier = Modifier.padding(30.dp)
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(20.dp)
                    ) {
                        Row {
                            Text(
                                text = "Mis Planetas",
                                textAlign = TextAlign.Center,
                                color = Color.Black,
                                modifier = Modifier.padding(10.dp)
                            )
                        }
                        Row(
                            modifier = Modifier.fillMaxWidth()
                        ){
                            Column(
                                horizontalAlignment = Alignment.CenterHorizontally,
                                modifier = Modifier.width(80.dp)
                            ) {
                                PlanetHeladoImage(
                                    Modifier.align(
                                        Alignment.Start
                                    )
                                )
                                Text(
                                    text = "Frozen planet",
                                    textAlign = TextAlign.Center,
                                    color = Color.Black,
                                    modifier = Modifier.padding(10.dp)
                                )
                            }
                            Column(
                                horizontalAlignment = Alignment.CenterHorizontally,
                                modifier = Modifier.width(100.dp)
                            ) {
                                PlanetPantanosoImage(
                                    Modifier.align(
                                        Alignment.Start
                                    )
                                )
                                Text(
                                    text = "Pantanoso",
                                    textAlign = TextAlign.Center,
                                    color = Color.Black,
                                    modifier = Modifier.padding(10.dp)
                                )
                            }
                            Column(
                                horizontalAlignment = Alignment.CenterHorizontally,
                                modifier = Modifier.width(100.dp)
                            ) {
                                PlanetVenenosoImage(
                                    Modifier.align(
                                        Alignment.Start
                                    )
                                )
                                Text(
                                    text = "Venenoso",
                                    textAlign = TextAlign.Center,
                                    color = Color.Black,
                                    modifier = Modifier.padding(10.dp)
                                )
                            }
                        }
                        Row(
                            modifier = Modifier.fillMaxWidth()
                        ){
                            Column(
                                horizontalAlignment = Alignment.CenterHorizontally,
                                modifier = Modifier.width(80.dp)
                            ) {
                                PlanetRobotImage(
                                    Modifier.align(
                                        Alignment.Start
                                    )
                                )
                                Text(
                                    text = "Robot Planet",
                                    textAlign = TextAlign.Center,
                                    color = Color.Black,
                                    modifier = Modifier.padding(10.dp)
                                )
                            }
                            Column(
                                horizontalAlignment = Alignment.CenterHorizontally,
                                modifier = Modifier.width(80.dp)
                            ) {
                                PlanetMisteriosoImage(
                                    Modifier.align(
                                        Alignment.Start
                                    )
                                )
                                Text(
                                    text = "Misterio",
                                    textAlign = TextAlign.Center,
                                    color = Color.Black,
                                    modifier = Modifier.padding(10.dp)
                                )
                            }
                        }
                        Row{
                            Column() {
                                Text(
                                    text = "Legendary",
                                    textAlign = TextAlign.Center,
                                    color = Color.Black,
                                    modifier = Modifier.padding(10.dp)
                                )
                            }
                            Column() {
                                Text(
                                    text = "Supremo",
                                    textAlign = TextAlign.Center,
                                    color = Color.Black,
                                    modifier = Modifier.padding(10.dp)
                                )
                            }
                            Column() {
                                Text(
                                    text = "Normal",
                                    textAlign = TextAlign.Center,
                                    color = Color.Black,
                                    modifier = Modifier.padding(10.dp)
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}
@Composable
fun PlanetPantanosoImage(modifier: Modifier) {
    Image(
        painter = painterResource(id = R.drawable.planeta_pantanosofin),
        contentDescription = "Space Sweet Logo",
        modifier = Modifier.size(40.dp)
    )
}

@Composable
fun PlanetHeladoImage(modifier: Modifier) {
    Image(
        painter = painterResource(id = R.drawable.planeta_heladofin),
        contentDescription = "Space Sweet Logo",
        modifier = Modifier.size(40.dp)
    )
}
@Composable
fun PlanetVenenosoImage(modifier: Modifier) {
    Image(
        painter = painterResource(id = R.drawable.planeta_venenoso),
        contentDescription = "Space Sweet Logo",
        modifier = Modifier.size(40.dp)
    )
}
@Composable
fun PlanetRobotImage(modifier: Modifier) {
    Image(
        painter = painterResource(id = R.drawable.planetarobotfin),
        contentDescription = "Space Sweet Logo",
        modifier = Modifier.size(40.dp)
    )
}
@Composable
fun PlanetMisteriosoImage(modifier: Modifier) {
    Image(
        painter = painterResource(id = R.drawable.planetamisterioso),
        contentDescription = "Space Sweet Logo",
        modifier = Modifier.size(40.dp)
    )
}