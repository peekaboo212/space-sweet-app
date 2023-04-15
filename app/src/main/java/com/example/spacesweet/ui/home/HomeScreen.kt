package com.example.spacesweet.ui.home

import android.annotation.SuppressLint
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
@SuppressLint("UnusedMaterialScaffoldPaddingParameter")

@Composable
fun HomeScreen(viewModel: CountDownViewModel){
    var hour = 0

    Scaffold (topBar = {
        TopAppBar(
            title = {
                Text(
                    text = "Space Sweet",
                    textAlign = TextAlign.Center,
                    color = Color(0xFF6D46D7),
                    modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp),
                )
            },
            backgroundColor = Color(0xFFffffff)
        )
    }
    ){
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
                        pTextField(
                            value = hour,
                            onValueChange = { },
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(bottom = 10.dp)
                                .background(Color.White)
                                .border(BorderStroke(1.dp, Color.Black), RoundedCornerShape(0.dp, 0.dp, 0.dp, 1.dp)),
                            colors = TextFieldDefaults.textFieldColors(
                                textColor = Color.Black,
                                backgroundColor = Color.White,
                                focusedIndicatorColor = Color.Transparent,
                                unfocusedIndicatorColor = Color.Transparent
                            )
                        )
                        viewModel.apply {
                            Text(text = timerText.value, fontSize = 28.sp)
                            Button(onClick = {
                                viewModel.hour.value = hour // Establece el valor de hour en 2
                                startCountDownTimer()},
                                modifier = Modifier.fillMaxWidth()
                            ) {
                                Text(text = "Start")
                            }
                            if(hasFinished.value) {
                                AlertDialog(
                                    onDismissRequest = { hasFinished.value }, // Cuando el usuario presiona fuera del diálogo
                                    title = { Text("¡Lo has logrado!") },
                                    text = { Text("Has ganado un planeta, sigue así") },
                                    confirmButton = {
                                        Button(onClick = { stopCountDownTimer() }) {
                                            Text("Seguir explorando")
                                        }
                                    }
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
fun pruebita() {
    TextField(
        value = hour,
        onValueChange = { },
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 10.dp)
            .background(Color.White)
            .border(BorderStroke(1.dp, Color.Black), RoundedCornerShape(0.dp, 0.dp, 0.dp, 1.dp)),
        colors = TextFieldDefaults.textFieldColors(
            textColor = Color.Black,
            backgroundColor = Color.White,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent
        )
    )
}