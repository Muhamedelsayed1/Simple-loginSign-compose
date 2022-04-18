package com.example.simple_loginsign_compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.simple_loginsign_compose.ui.theme.SimpleloginSigncomposeTheme
import com.example.simple_loginsign_compose.view.LoginPage
import com.example.simple_loginsign_compose.view.Register

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SimpleloginSigncomposeTheme {
               navigatePage()

            }
        }
    }
    // this method to set up my design in main activity and show it
@Composable
     fun navigatePage() {
      val navController = rememberNavController()
    // nav host used to show my design
    NavHost(navController = navController , startDestination = "login_Page", builder = {
        composable("login_Page", content = { LoginPage(navController = navController)})
        composable("register_page", content = { Register(navController = navController) })

    })
    }
}


