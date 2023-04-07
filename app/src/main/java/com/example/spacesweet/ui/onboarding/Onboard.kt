package com.example.spacesweet.ui.onboarding

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

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun Onboard(
    navController: NavHostController,
    title: String,
    image: Int,
    description: String,
    nextRoute: String,
    buttonTitle: String,
){
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
                        Text(
                            text = title,
                            textAlign = TextAlign.Center,
                            modifier = Modifier.padding(bottom = 30.dp)
                        )
                        Image(
                            painter = painterResource(id = image),
                            contentDescription = "My Image",
                            modifier = Modifier.size(128.dp).padding(bottom = 30.dp)
                        )
                        Text(
                            text = description,
                            textAlign = TextAlign.Center,
                            modifier = Modifier.padding(bottom = 30.dp)
                        )
                        Button(onClick = { navController.navigate(nextRoute)},
                        modifier = Modifier.fillMaxWidth()
                        ) {
                            Text(text = buttonTitle,)
                        }
                    }
                }
            }
        }
    }
}