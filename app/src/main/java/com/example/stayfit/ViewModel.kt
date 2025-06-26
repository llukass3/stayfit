package com.example.stayfit

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

class ViewModel() {

    var currentWorkout by  mutableStateOf<Workout?>(null)
        private set

    var currentExercise by mutableStateOf<Exercise?>(currentWorkout?.currentExercise())
        private set

    var progress by mutableFloatStateOf(0f)
        private set
}