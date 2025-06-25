package com.example.stayfit

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.stayfit.screens.MenuScreen
import com.example.stayfit.screens.WorkoutScreen
import com.example.stayfit.ui.theme.StayfitTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()
            NavHost(navController = navController, startDestination = "") {
                composable(route = "menu_screen") {
                    MenuScreen(navController)
                }
                composable(route = "workout_screen" + "/{needHelpHere}") {
                    WorkoutScreen(navController)
                }
            }
        }
    }
}

@Composable
fun Header() {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .height(120.dp)
            .fillMaxWidth()
            .background(color = Color.hsl(240f, 0f, 0.15f))
    ) {
        Image(
            painter = painterResource(R.drawable.logo),
            contentDescription = "logo")
    }
}