package com.example.spacesweet.ui.home

import android.annotation.SuppressLint
import android.graphics.Insets.add
import android.os.Build.VERSION.SDK_INT
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import coil.ImageLoader
import coil.compose.rememberAsyncImagePainter
import coil.decode.GifDecoder
import coil.decode.ImageDecoderDecoder
import com.example.spacesweet.R

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")

@Composable
fun HomeScreen(viewModel: CountDownViewModel){
    var userInputHours by remember { mutableStateOf(0) }
    var userInputMinutes by remember { mutableStateOf(0) }
    var userInputSeconds by remember { mutableStateOf(0) }

    Scaffold (topBar = {
        TopAppBar(
            title = {
                Text(
                    text = "Space Sweet",
                    textAlign = TextAlign.Center,
                    color = Color(0xFF6D46D7),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp),
                )
            },
            backgroundColor = Color(0xFFffffff)
        )
    }
    ){

        Box(
            modifier = Modifier.fillMaxSize()
        ) {
            SpaceBackground()
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxSize()
            ) {
                Astronaut()
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
                        NumericInputField(
                            value = userInputHours,
                            maxValue = 24,
                            placeholderText = "Horas"
                        ) { newHourValue ->
                            userInputHours = newHourValue
                        }

                        NumericInputField(
                            value = userInputMinutes,
                            maxValue = 59,
                            placeholderText = "Minutos"
                        ) { newMinuteValue ->
                            userInputMinutes = newMinuteValue
                        }

                        NumericInputField(
                            value = userInputSeconds,
                            maxValue = 59,
                            placeholderText = "Segundos"
                        ) { newSecondValue ->
                            userInputSeconds = newSecondValue
                        }

                        viewModel.apply {
                            Text(text = timerText.value, fontSize = 28.sp)
                            Button(onClick = {
                                viewModel.userInputHours.value = userInputHours
                                viewModel.userInputMinutes.value = userInputMinutes
                                viewModel.userInputSeconds.value = userInputSeconds
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
fun NumericInputField(
    value: Int,
    maxValue: Int,
    placeholderText: String,
    onValueChange: (Int) -> Unit
) {
    TextField(
        value = if (value == 0) "" else value.toString(),
        onValueChange = { newValue ->
            val newValueInt = newValue.toIntOrNull()
            if (newValueInt != null && newValueInt <= maxValue) {
                onValueChange(newValueInt)
            } else if (newValue.isEmpty()) {
                onValueChange(0)
            }
        },
        placeholder = {
            Text(text = placeholderText, color = Color.Gray)
        },
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 10.dp)
            .background(Color.White)
            .border(
                BorderStroke(1.dp, Color.Black),
                RoundedCornerShape(0.dp, 0.dp, 0.dp, 1.dp)
            ),
        colors = TextFieldDefaults.textFieldColors(
            textColor = Color.Black,
            backgroundColor = Color.White,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent
        ),
        keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number)
    )
}

@Composable
fun Astronaut() {
    val imageLoader = ImageLoader.Builder(LocalContext.current)
        .components {
            if (SDK_INT >= 28) {
                add(ImageDecoderDecoder.Factory())
            } else {
                add(GifDecoder.Factory())
            }
        }
        .build()

    Image(
        painter = rememberAsyncImagePainter(R.drawable.normal_astronaut, imageLoader),
        contentDescription = null,
        modifier = Modifier
            .size(200.dp)
            .padding(bottom = 10.dp)
    )
}

@Composable
fun SpaceBackground() {
    val imageLoader = ImageLoader.Builder(LocalContext.current)
        .components {
            if (SDK_INT >= 28) {
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