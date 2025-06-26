package com.example.stayfit.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
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
import com.example.stayfit.Background
import com.example.stayfit.Header
import com.example.stayfit.Workout
import com.example.stayfit.sampleData.workout1
import com.example.stayfit.sampleData.workout2

//Im Menü können die User*innen ein Workout auswählen

@Composable
fun MenuScreen(workoutList: List<Workout>, onWorkoutChosen: (workoutId: Int) -> Unit) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Header()
        WorkoutList(workoutList, onWorkoutChosen = { onWorkoutChosen(it) })
    }
}

/*eine Liste aller verfügbaren Workouts. Die Callback Funktion onWorkoutChosen wird
* aufgerufen, wenn ein Workout ausgewählt wird und übergibt die ID des ausgewählten Workouts */

@Composable
fun WorkoutList(workoutList: List<Workout>, onWorkoutChosen: (workoutId: Int) -> Unit) {
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

        for (workout in workoutList) {
            WorkoutListEntry(workout, onClick = { onWorkoutChosen(workout.id) })
        }
    }
}

//repräsentiert einen Listeneintrag einzelnes Workout
@Composable
fun WorkoutListEntry(workout: Workout, onClick: () -> Unit) {
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
                onClick()
            }
    ){
        //Preview Bild des Workouts
        Image(
            painter = painterResource(workout.exercises[0].images[0]),
            contentDescription = "${workout.name} preview"
        )
        Column(
            modifier = Modifier.padding(start = 20.dp)
        ) {
            //Name des Workouts
            Text(
                text = workout.name,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                modifier = Modifier.padding(bottom = 5.dp)
            )
            //Anzahl an Übungen
            Text(
                text = "Anzahl Übungen: ${workout.exercises.size}",
                fontSize = 13.sp,
                color = Color.White
            )

            Text(
                "Dauer: ca. 5 min.",
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
        WorkoutList(listOf(workout1, workout2), onWorkoutChosen = {})
    }
}