package com.example.stayfit.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.stayfit.Background
import com.example.stayfit.Exercise
import com.example.stayfit.Header
import com.example.stayfit.sampleData.exercise1
import kotlinx.coroutines.delay
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.setValue


//Dieser Screen ist eine Detaillierte Ansicht einer Übung.
@Composable
fun WorkoutScreen(
    exercise: Exercise,
    onExerciseComplete: () -> Unit) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Header()
        Exercise(exercise, onExerciseComplete = onExerciseComplete)
        Progress()
    }
}

//Eine Übung des Workouts wird angezeigt.
@Composable
fun Exercise(exercise: Exercise, onExerciseComplete: () -> Unit) {

    // Tauscht die Bilder der Übung periodisch aus, sodass eine Animation entsteht
    var imageIndex by remember { mutableIntStateOf(0) }
    LaunchedEffect(exercise) {
        while (true) {
            delay(1000) // Wait 2 seconds
            imageIndex = (imageIndex + 1) % exercise.images.size
        }
    }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(30.dp),
        modifier = Modifier
            .padding(top = 50.dp)
    ) {
        //Visualisierung der Übung
        Box(contentAlignment = Alignment.Center) {
            Icon(
                imageVector = Icons.Filled.Check,
                contentDescription = "contentDescription",
                modifier = Modifier
                    .size(250.dp)
                    .background(Color.White, CircleShape),
                tint = Color.White
            )
            Image(
                painter = painterResource(id = exercise.images[imageIndex]),
                contentDescription = "exercise image"
            )
        }
        //Name der Übung
        Text(
            text = exercise.name,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White,
            modifier = Modifier
                .background(Color.hsl(31f, 1f, 0.5f))
                .padding(6.dp)
        )
        //Beschreibung der Übung
        Text(
            text = exercise.description,
            fontSize = 17.sp,
            textAlign = TextAlign.Center,
            color = Color.White,
            modifier = Modifier.width(300.dp)
        )
    }

    // TODO: Button Löschen und stattdessen Timer einfügen,
    /* nach Ablauf des Timers wird onExerciseComplete aufgerufen.
       Verwende für den Timer die Property "duration" der Klasse Exercise.
     */
    Button(
        onClick = onExerciseComplete,
        modifier = Modifier
            .padding(top = 60.dp)
    ) {
        Text("Fertig")
    }
}

/*TODO, Anzeige, die den Fortschritt des Workouts darstellt.
Im Viewmodel ist bereits eine Variable "progess" angelegt */
@Composable
fun Progress() {
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
        WorkoutScreen(exercise1, onExerciseComplete = {})
    }
}