package com.example.spacesweet.ui.login.ui

import android.annotation.SuppressLint
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.example.spacesweet.R
import kotlinx.coroutines.launch

import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.navigation.NavHostController

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun LoginScreen(viewModel: LoginViewModel, navController: NavHostController) {

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
                        modifier = Modifier.fillMaxWidth().padding(3.dp)
                    ) {
                        Login(viewModel, navController)
                    }
                }
            }
        }
    }
}


@Composable
fun Login(viewModel: LoginViewModel, navController: NavHostController) {
    val email: String by viewModel.email.observeAsState(initial = "")
    val password: String by viewModel.password.observeAsState(initial = "")
    val loginEnable: Boolean by viewModel.loginEnable.observeAsState(initial = false)
    val isLoading: Boolean by viewModel.isLoading.observeAsState(initial = false)

    val coroutineScope = rememberCoroutineScope()

    if(isLoading) {
        Box {
            CircularProgressIndicator(Modifier.align(Alignment.Center))
        }
    }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxWidth().padding(30.dp)
    ) {
        HeaderImage(Modifier.align(Alignment.CenterHorizontally))
        EmailField(email) {viewModel.onLoginChanged(it, password)}
        PasswordField(password) { viewModel.onLoginChanged(email, it) }
        LoginButton(loginEnable) {
            coroutineScope.launch {
                viewModel.onLoginSelected()
            }
        }
        RegisterButton(Modifier.align(Alignment.End), navController)
    }
}

@Composable
fun LoginButton(loginEnable: Boolean, onLoginSelected: () -> Unit) {
    Button(
        onClick = { onLoginSelected() },
        modifier = Modifier
            .fillMaxWidth()
            .height(48.dp),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = Color(0xFF0074B6),
            disabledBackgroundColor = Color(0xFF77A5C7),
            contentColor = Color.White,
            disabledContentColor = Color.White
        ),
        enabled = loginEnable
    ) {
        Text(text = "Iniciar Sesión")
    }
}
                                                    
@Composable
fun RegisterButton(modifier: Modifier, navController: NavHostController) {
    TextButton(
        onClick = { navController.navigate("register") },

    ) {
        Text("Registrate")
    }
}

@Composable
fun PasswordField(password: String, onTextFieldChanged: (String) -> Unit) {
    var hidden by remember { mutableStateOf(true) }

    TextField(
        value = password,
        onValueChange = {onTextFieldChanged(it)},
        modifier = Modifier.fillMaxWidth().padding(bottom = 10.dp)
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
fun EmailField(email: String, onTextFieldChanged: (String) -> Unit) {
    TextField(
        value = email,
        onValueChange = { onTextFieldChanged(it) },
        modifier = Modifier.fillMaxWidth().padding(bottom = 10.dp)
            .background(Color.White)
            .border(BorderStroke(1.dp, Color.Black), RoundedCornerShape(0.dp, 0.dp, 0.dp, 1.dp)),
        leadingIcon = {
            Icon(imageVector = Icons.Default.Email, contentDescription = "Email Icon",
                tint = Color.Black)
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
fun HeaderImage(modifier: Modifier) {
    Image(
        painter = painterResource(id = R.drawable.astronaut),
        contentDescription = "Space Sweet Logo",
        modifier = Modifier.size(200.dp).padding(bottom = 10.dp)
    )
}
