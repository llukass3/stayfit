package com.example.stayfit

data class Exercise(
    val name: String,
    val description: String,
    val duration: Float,
    val images: List<Int>
)

data class Workout(
    val name: String,
    val id: Int,
    val exercises: List<Exercise>,
)
