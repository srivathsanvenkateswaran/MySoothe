package com.srivathsanvenkateswaran.mysoothe

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.srivathsanvenkateswaran.mysoothe.composables.HomeScreen
import com.srivathsanvenkateswaran.mysoothe.composables.LogInScreen
import com.srivathsanvenkateswaran.mysoothe.composables.WelcomeScreen
import com.srivathsanvenkateswaran.mysoothe.ui.theme.MySootheTheme
import com.srivathsanvenkateswaran.mysoothe.utils.Screen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MySootheTheme {
                val navController = rememberNavController()

                NavHost(
                    navController = navController,
                    startDestination = Screen.WelcomeScreen.route
                ) {
                    composable(
                        route = Screen.WelcomeScreen.route
                    ) {
                        WelcomeScreen(
                            onLoginClick = {
                                navController.navigate(Screen.LogInScreen.route)
                            },
                            onSignUpClick = {
                                Toast.makeText(this@MainActivity, "Signing up...", Toast.LENGTH_SHORT).show()
                                navController.navigate(Screen.HomeScreen.route)
                            }
                        )
                    }

                    composable(
                        route = Screen.LogInScreen.route
                    ) {
                        LogInScreen {
                            Toast.makeText(this@MainActivity, "Logging in...", Toast.LENGTH_SHORT).show()
                            navController.navigate(Screen.HomeScreen.route)
                        }
                    }

                    composable(
                        route = Screen.HomeScreen.route
                    ) {
                        HomeScreen()
                    }
                }
            }
        }
    }
}