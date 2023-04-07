package com.example.spacesweet.ui.register

import android.annotation.SuppressLint
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.spacesweet.R
import com.example.spacesweet.ui.login.ui.*

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun RegisterScreen(
    navController: NavHostController,
){
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
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(3.dp)
                    ) {
                        Register(navController)
                    }
                }
            }
        }
    }
}

@Composable
fun Register(navController: NavHostController){
    var name by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxWidth()
            .padding(30.dp)
    ) {
        NameFiel(name)
        EmailField(email)
        PasswordField(password)
        RegisterButton(navController)
    }
}

@Composable
fun NameFiel(name:String){
    TextField(
        value = name,
        onValueChange = { },
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 10.dp)
            .background(Color.White)
            .border(BorderStroke(1.dp, Color.Black), RoundedCornerShape(0.dp, 0.dp, 0.dp, 1.dp)),
        leadingIcon = {
            Icon(
                imageVector = Icons.Default.Person, contentDescription = "Email Icon",
                tint = Color.Black
            )
        },
        placeholder = {
            Text(text = "Email", color = Color.Gray)
        },
        colors = TextFieldDefaults.textFieldColors(
            textColor = Color.Black,
            backgroundColor = Color.White,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent
        )
    )
}
@Composable
fun EmailField(email: String) {
    TextField(
        value = email,
        onValueChange = { },
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 10.dp)
            .background(Color.White)
            .border(BorderStroke(1.dp, Color.Black), RoundedCornerShape(0.dp, 0.dp, 0.dp, 1.dp)),
        leadingIcon = {
            Icon(
                imageVector = Icons.Default.Email, contentDescription = "Email Icon",
                tint = Color.Black
            )
        },
        placeholder = {
            Text(text = "Email", color = Color.Gray)
        },
        colors = TextFieldDefaults.textFieldColors(
            textColor = Color.Black,
            backgroundColor = Color.White,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent
        )
    )
}

@Composable
fun PasswordField(password: String) {
    var hidden by remember { mutableStateOf(true) }

    TextField(
        value = password,
        onValueChange = {},
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 10.dp)
            .background(Color.White)
            .border(BorderStroke(1.dp, Color.Black), RoundedCornerShape(0.dp, 0.dp, 0.dp, 1.dp)),
        leadingIcon = {
            Icon(imageVector = Icons.Default.Email, contentDescription = "Email Icon",
                tint = Color.Black)
        },
        placeholder = { Text(text = "Contraseña") },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        singleLine = true,
        colors = TextFieldDefaults.textFieldColors(
            textColor = Color.Black,
            backgroundColor = Color.White,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent
        ),
        visualTransformation =
        if (hidden) PasswordVisualTransformation() else VisualTransformation.None,
        trailingIcon = {// 4
            IconButton(
                onClick = { hidden = !hidden },
                content = {
                    val iconSize = if (hidden) 24.dp else 24.dp

                    Icon(
                        modifier = Modifier.size(iconSize),
                        painter = painterResource(if (hidden) R.drawable.ic_visibility else R.drawable.ic_visibility_off),
                        contentDescription = if (hidden) "Ocultar contraseña" else "Revelar contraseña",
                    )
                }
            )
        }
    )
}

@Composable
fun RegisterButton(navController: NavHostController) {
    Button(
        onClick = { navController.navigate("login") },
        modifier = Modifier
            .fillMaxWidth()
            .height(48.dp),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = Color(0xFF0074B6),
            contentColor = Color.White,
        ),
    ) {
        Text(text = "Regístrate")
    }
}


