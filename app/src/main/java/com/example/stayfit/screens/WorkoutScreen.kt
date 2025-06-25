package com.example.stayfit.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.stayfit.Background
import com.example.stayfit.Header
import com.example.stayfit.R

@Composable
fun WorkoutScreen(navController: NavController) {
    Background()
}

@Composable
fun Exercise() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(10.dp),
    ) {
        Box(
            contentAlignment = Alignment.Center,
        ){
            Icon(
                imageVector = Icons.Filled.Check,
                contentDescription = "contentDescription",
                modifier = Modifier
                    .size(250.dp)
                    .background(Color.White, CircleShape),
                tint = Color.White
            )
            Image(
                painter = painterResource(R.drawable.exercise2_1),
                contentDescription = "logo"
            )
        }
        Text(
            "Fett verbrennen",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White,
            modifier = Modifier
                .background(Color.hsl(31f, 1f, 0.5f))
                .padding(all = 6.dp)
        )
        Text(
            "Lorem ipsum Dolor sit amet lorem ipsum dolor sit amet lorem ipsum",
            fontSize = 15.sp,
            textAlign = TextAlign.Center,
            color = Color.White,
            modifier = Modifier
                .width(300.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun WorkoutScreenPreview() {
    Background()
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Header()
        Exercise()
    }
}