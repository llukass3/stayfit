package com.example.stayfit

import android.media.Image
import kotlin.time.Duration

data class Exercise(
    val name: String,
    val description: String,
    val duration: Duration,
    val images: List<Image>
)

data class Workout(
    val name: String,
    val exercises: List<Exercise>
)
