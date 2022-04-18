package com.example.simple_loginsign_compose.view

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.simple_loginsign_compose.R
import com.example.simple_loginsign_compose.ui.theme.Purple500

@Composable
fun Register(navController: NavController) {

    val context = LocalContext.current // this allow me to control all the page or the context
    val scaffoldState = rememberScaffoldState()
    val nameVal = remember { mutableStateOf("") } // edittext to email.
    val emailVal = remember { mutableStateOf("") } // edittext to email.
    val phoneVal = remember { mutableStateOf("") } // edittext to email.
    val passwordVal = remember { mutableStateOf("") } // edittext to email.
    val confirmPasswordVal = remember { mutableStateOf("") } // edittext to email.
    val passwordVisiblity = remember { mutableStateOf(false) } // edittext to email.
    val conirmPasswordVisibility = remember { mutableStateOf(false) } // edittext to email.
    //all of them is the variables that i need to design my screen

    //to set a photo in the center of page
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
                        .width(200.dp)
                        .height(200.dp),
                    painter = painterResource(id = R.drawable.regiset_img),
                    contentDescription = "Register Image",
                    contentScale = ContentScale.Fit
                )

            }
            Scaffold(modifier = Modifier.fillMaxSize(), scaffoldState = scaffoldState) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center, modifier = Modifier
                        .fillMaxWidth()
                        .background(Color.White)
                        .padding(10.dp)
                ) {
                    Text(
                        text = "Sign up",
                        fontSize = 30.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black
                    )
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        OutlinedTextField(
                            value = nameVal.value,
                            onValueChange = { nameVal.value = it },
                            label = { Text(text = "Name", color = Color.Black) },
                            placeholder = { Text(text = "Name ", color = Color.Black) },
                            singleLine = true // to write only one line in the text filed
                            ,
                            modifier = Modifier.fillMaxWidth(0.8f),
                            colors = TextFieldDefaults.outlinedTextFieldColors(
                                unfocusedBorderColor = Color.Black,
                                textColor = Color.Black
                            )
                        )

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
                                    value = phoneVal.value,
                                    onValueChange = { phoneVal.value = it },
                                    label = { Text(text = "phone", color = Color.Black) },
                                    placeholder = { Text(text = "phone", color = Color.Black) },
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
                                        label = { Text(text = "Password", color = Color.Black) },
                                        placeholder = {
                                            Text(
                                                text = "Password",
                                                color = Color.Black
                                            )
                                        },
                                        singleLine = true, // to write only one line in the text filed
                                        modifier = Modifier.fillMaxWidth(0.8f),
                                        colors = TextFieldDefaults.outlinedTextFieldColors(
                                            unfocusedBorderColor = Color.Black,
                                            textColor = Color.Black
                                        ),
                                        trailingIcon = {
                                            IconButton(onClick = {
                                                passwordVisiblity.value = !passwordVisiblity.value

                                            }) {
                                                Icon(
                                                    painter = painterResource(R.drawable.ic_baseline_remove_red_eye_24),
                                                    contentDescription = "Password eye",
                                                    tint = if (passwordVisiblity.value) Purple500 else Color.Gray
                                                )

                                            }

                                        },
                                        visualTransformation = if (passwordVisiblity.value) VisualTransformation.None else PasswordVisualTransformation(),//to show or hide password

                                    )
                        OutlinedTextField(
                            value = confirmPasswordVal.value,
                            onValueChange = { confirmPasswordVal.value = it },
                            label = { Text(text = "Confirm Password", color = Color.Black) },
                            placeholder = {
                                Text(
                                    text = "Confirm Password",
                                    color = Color.Black
                                )
                            },
                            singleLine = true, // to write only one line in the text filed
                            modifier = Modifier.fillMaxWidth(0.8f),
                            colors = TextFieldDefaults.outlinedTextFieldColors(
                                unfocusedBorderColor = Color.Black,
                                textColor = Color.Black
                            ),
                            trailingIcon = {
                                IconButton(onClick = {
                                    passwordVisiblity.value = !passwordVisiblity.value

                                }) {
                                    Icon(
                                        painter = painterResource(R.drawable.ic_baseline_remove_red_eye_24),
                                        contentDescription = "Password eye",
                                        tint = if (passwordVisiblity.value) Purple500 else Color.Gray
                                    )

                                }

                            },
                            visualTransformation = if (passwordVisiblity.value) VisualTransformation.None else PasswordVisualTransformation(),//to show or hide password

                        )
                        Spacer(modifier = Modifier.padding(15.dp))
                        Button(
                            colors = ButtonDefaults.buttonColors(backgroundColor = Color.Blue),
                            onClick = {
                                when {
                                    nameVal.value.isEmpty() -> {
                                        Toast.makeText(
                                            context,
                                            "please enter your Name",
                                            Toast.LENGTH_LONG
                                        ).show()
                                    }
                                    emailVal.value.isEmpty() -> {
                                        Toast.makeText(
                                            context,
                                            "please enter your email",
                                            Toast.LENGTH_LONG
                                        ).show()
                                    }
                                    phoneVal.value.isEmpty() -> {
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
                                    confirmPasswordVal.value.isEmpty() -> {
                                        Toast.makeText(
                                            context,
                                            "please enter your Confirm Your Password!",
                                            Toast.LENGTH_LONG
                                        ).show()
                                    }
                                    else -> {
                                        Toast.makeText(context, "Signed done", Toast.LENGTH_LONG)
                                            .show()
                                    }


                                }
                            },
                            modifier = Modifier
                                .fillMaxWidth(0.8f)
                                .height(50.dp)
                        ) {  Text(
                            text = "Sign UP",
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.White
                        )
                        }
                        Spacer(modifier = Modifier.padding(15.dp))
                        Text(
                            text = "Have Account ? Login",
                            color = Color.Black,
                            modifier = Modifier.clickable { navController.navigate("login_page") }
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


