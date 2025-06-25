package com.example.stayfit

import android.media.Image
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import kotlin.time.Duration

data class Exercise(
    val name: String,
    val description: String,
    val duration: Float,
    val images: List<Int>
)

data class Workout(
    val name: String,
    val exercises: List<Exercise>
)

val sampleExercise = Exercise(
    "Liegestütze",
    "Mache Liegestützte",
    10f,
    listOf(
        R.drawable.exercise2_1,
        R.drawable.exercise2_2
        ),
)
