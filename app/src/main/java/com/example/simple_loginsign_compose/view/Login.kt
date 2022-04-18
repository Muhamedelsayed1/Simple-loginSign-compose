package com.example.simple_loginsign_compose.view

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.simple_loginsign_compose.R
import com.example.simple_loginsign_compose.ui.theme.Purple200
import com.example.simple_loginsign_compose.ui.theme.Purple500

@Composable
fun LoginPage(navController: NavController) //this method allow me to control my page
{
    val context = LocalContext.current // this allow me to control all the page or the context
    val scaffoldState = rememberScaffoldState()
    val emailVal = remember { mutableStateOf("") } // edittext to email.
    val passwordVal = remember { mutableStateOf("") } // edittext to email.
    val passwordVisiblity = remember { mutableStateOf(false) } // edittext to email.
    //all of them is the variables that i need to design my screen
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White), contentAlignment = Alignment.Center
    ) {
        // 7sb el design beta3y me7tag a7ot sora fe nos el screen fa hna b7ot el ab3ad bta3t el img deh
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center, modifier = Modifier.fillMaxWidth()
        ) {
            Box(
                modifier = Modifier.background(Color.White),
                contentAlignment = Alignment.TopCenter
            ) {
                Image(
                    modifier = Modifier
                        .width(400.dp)
                        .height(350.dp),
                    painter = painterResource(id = R.drawable.login),
                    contentDescription = "Login Image",
                    contentScale = ContentScale.Fit
                )

            }
            // to set a space between the designs (2 coluoms)
            Spacer(modifier = Modifier.padding(5.dp))

            // this method will contain the  second part of design
            Scaffold(
                modifier = Modifier.fillMaxSize(),
                scaffoldState = scaffoldState
            ) { // scaffold state like a container to pick up the design
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center, modifier = Modifier
                        .fillMaxWidth()
                        .background(Color.White)
                        .padding(10.dp)
                ) {
                    Text(
                        text = "Sign In",
                        fontSize = 30.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black
                    )
                    Spacer(modifier = Modifier.padding(0.dp))
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        OutlinedTextField(
                            value = emailVal.value,
                            onValueChange = { emailVal.value = it },
                            label = { Text(text = "Email Address", color = Color.Black) },
                            placeholder = { Text(text = "Email Address", color = Color.Black) },
                            singleLine = true // to write only one line in the text filed
                            ,
                            modifier = Modifier.fillMaxWidth(0.8f),
                            colors = TextFieldDefaults.outlinedTextFieldColors(
                                unfocusedBorderColor = Color.Black,
                                textColor = Color.Black
                            )
                        )
                        OutlinedTextField(
                            value = passwordVal.value,
                            onValueChange = { passwordVal.value = it },
                            colors = TextFieldDefaults.outlinedTextFieldColors(
                                unfocusedBorderColor = Color.Black,
                                textColor = Color.Black
                            ),
                            trailingIcon = { //to make icon clickable and change colour of icon
                                IconButton(onClick = {
                                    passwordVisiblity.value = !passwordVisiblity.value
                                }) {
                                    Icon(
                                        painter = painterResource(R.drawable.ic_baseline_remove_red_eye_24),
                                        contentDescription = "password",
                                        tint = if (passwordVisiblity.value) Purple500 else Color.Gray
                                    )

                                }
                            },
                            label = { Text(text = "Password", color = Color.Black) },
                            placeholder = { Text(text = "Password", color = Color.Black) },
                            singleLine = true, // to write only one line in the text filed
                            visualTransformation = if (passwordVisiblity.value) VisualTransformation.None else PasswordVisualTransformation(),//to show or hide password
                            modifier = Modifier.fillMaxWidth(0.8f)
                        )
                        Spacer(modifier = Modifier.padding(15.dp))
                        Button(
                            colors = ButtonDefaults.buttonColors(backgroundColor = Color.Yellow),
                            onClick = {
                                when {
                                    emailVal.value.isEmpty() -> {
                                        Toast.makeText(
                                            context,
                                            "please enter your email",
                                            Toast.LENGTH_LONG
                                        ).show()
                                    }
                                    passwordVal.value.isEmpty() -> {
                                        Toast.makeText(
                                            context,
                                            "please enter your Password",
                                            Toast.LENGTH_LONG
                                        ).show()
                                    }
                                    else -> {
                                        Toast.makeText(context, "logged done", Toast.LENGTH_LONG)
                                            .show()
                                    }


                                }
                            },
                            modifier = Modifier
                                .fillMaxWidth(0.8f)
                                .height(50.dp)
                        ) {  Text(
                            text = "Sign In",
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.Black
                        )
                        }
                        Spacer(modifier = Modifier.padding(15.dp))
                        Text(
                            text = "Create New Account",
                            color = Color.Black,
                            modifier = Modifier.clickable { navController.navigate("register_page") }
                        )
 //rout mean get rout for the page i want to go to it(communicate to pages with each other)
// navController is responsible for go to anther page
                        Spacer(modifier = Modifier.padding(5.dp))

                    }
                }

            }

        }

    }

}