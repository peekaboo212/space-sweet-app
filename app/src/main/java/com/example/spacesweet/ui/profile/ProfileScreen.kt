package com.example.spacesweet.ui.profile

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
fun ProfileScreen(){
    Scaffold (topBar = {
        TopAppBar(
            title = {
                Text(
                    text = "SpaceSweet",
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
                            painter = painterResource(id = R.drawable.profile),
                            contentDescription = "My Image",
                            modifier = Modifier.size(128.dp).padding(bottom = 30.dp)
                        )
                        Text(
                            text = "Username",
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
                        modifier = Modifier.fillMaxWidth().padding(30.dp)
                    ) {
                        Text(
                            text = "Email:",
                            modifier = Modifier.padding(bottom = 10.dp)
                        )
                        Text(
                            text = "Password:",
                            modifier = Modifier.padding(bottom = 10.dp)
                        )
                        Text(
                            text = "Objetivo diario:",
                            modifier = Modifier.padding(bottom = 10.dp)
                        )
                        Text(
                            text = "Stars:",
                            modifier = Modifier.padding(bottom = 10.dp)
                        )
                    }
                }
            }
        }
    }
}