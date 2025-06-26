package com.example.stayfit

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.stayfit.sampleData.workout1
import com.example.stayfit.sampleData.workout2

class WorkoutViewModel: ViewModel() {

    //Liste aller verfügbaren Workouts
    var workouts = listOf(workout1, workout2)

    //Das aktuell ausgewählte Workout
    var currentWorkout by  mutableStateOf<Workout?>(null)
        private set

    //Das gibt das entsprechende workout basierend auf der übergebenen ID zurück
    fun getWorkoutById(id: Int): Workout? {
        return workouts.find { it.id == id }
    }

    //Setzt das entsprechende workout basierend auf der übergebenen ID fest
    fun setCurrentWorkout(id: Int) {
        currentWorkout = getWorkoutById(id)
        currentExercise = currentWorkout?.exercises?.get(0)
        currentExerciseIndex = 0
    }

    //Index der aktuellen Übung im aktuellen Workout
    var currentExerciseIndex by mutableIntStateOf(0)

    //Die aktuelle Übung
    var currentExercise by mutableStateOf<Exercise?>(currentWorkout?.exercises?.get(0))
        private set

    //Funktion, um zur nächsten Übung über zu gehen
    fun nextExercise() {
        currentExerciseIndex++
        currentExercise = currentWorkout?.exercises?.get(currentExerciseIndex)
    }

    //TODO: Der Fortschritt der User*in im aktuellen Workout
    var progress by mutableFloatStateOf(0f)
        private set
}