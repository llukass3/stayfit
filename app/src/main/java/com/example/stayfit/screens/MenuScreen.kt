package com.example.stayfit.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.stayfit.Background
import com.example.stayfit.Header
import com.example.stayfit.R

@Composable
fun MenuScreen(navController: NavController) {
    Background()
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Header()
        WorkoutList()
    }
}

@Composable
fun WorkoutList() {
    Column(
        verticalArrangement = Arrangement.spacedBy(10.dp),
        modifier = Modifier
            .fillMaxSize()
            .padding(15.dp)
    ) {
        Text(
            "Wähle deine Übung:",
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White,
            modifier = Modifier
                .padding(bottom = 5.dp)
                .align(Alignment.Start)
        )
        WorkoutListEntry()
        WorkoutListEntry()
        WorkoutListEntry()
    }
}

@Composable
fun WorkoutListEntry() {
    Row (
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .height(100.dp)
            .fillMaxWidth()
            .border(
                border = BorderStroke(2.dp, Color.hsl(31f, 1f, 0.5f)),
                shape = RoundedCornerShape(8.dp)
            )
            .clickable {

            }
    ){
        Image(
            painter = painterResource(R.drawable.exercise2_1),
            contentDescription = "logo"
        )
        Column(
            modifier = Modifier.padding(start = 20.dp)
        ) {
            Text(
                "Fett verbrennen",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                modifier = Modifier.padding(bottom = 5.dp)
            )
            Text(
                "Übungen: 4",
                fontSize = 13.sp,
                color = Color.White
            )
            Text(
                "Dauer: 5 min.",
                fontSize = 13.sp,
                color = Color.White
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun FitnessAppPreview() {
    Background()
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Header()
        WorkoutList()
    }
}