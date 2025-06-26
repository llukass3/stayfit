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
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.stayfit.screens.MenuScreen
import com.example.stayfit.screens.WorkoutScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

            Background()

            //ViewModel
            val viewModel = viewModel<WorkoutViewModel>()

            //Navigation
            val navController = rememberNavController()
            NavHost(
                navController = navController,
                startDestination = MenuScreen
            ) {
                //Menü Screen, zum Auswählen eines Workouts
                composable<MenuScreen> {
                    MenuScreen(
                        workoutList = viewModel.workouts,
                        onWorkoutChosen = {
                            viewModel.setCurrentWorkout(it)
                            navController.navigate(WorkoutScreen)
                        }
                    )
                }
                //Workout Screen, zur Anzeige einer Übung
                composable<WorkoutScreen> {
                    WorkoutScreen(
                        exercise = viewModel.currentExercise!!,
                        onExerciseComplete = {
                            if (viewModel.currentExerciseIndex < viewModel.currentWorkout!!.exercises.size - 1)
                                //TODO: Pause, bevor nächste Übung angezeigt wird
                                //TODO: Sound abspielen, wenn übungen und Pausen starten und enden
                                //TODO: Fortschritt Speichern
                                viewModel.nextExercise()
                            else {
                                viewModel.currentExerciseIndex = 0
                                navController.navigate(MenuScreen)
                            }
                        }
                    )
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
            .padding(top = 20.dp)
    ) {
        Image(
            painter = painterResource(R.drawable.logo),
            contentDescription = "logo")
    }
}

@Composable
fun Background() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.hsl(240f, 0f, 0.2f))
    )
}