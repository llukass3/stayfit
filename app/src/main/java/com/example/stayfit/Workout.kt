package com.example.stayfit

data class Exercise(
    val name: String,
    val description: String,
    val duration: Float,
    val images: List<Int>
)

class Workout(
    val name: String,
    val exercises: List<Exercise>,
) {
    var currentExerciseIndex: Int = 0
        private set

    fun nextExercise(): Exercise {
        currentExerciseIndex =
            if (currentExerciseIndex < exercises.size - 1)
            currentExerciseIndex++
            else 0

        return exercises[currentExerciseIndex]
    }

    fun currentExercise(): Exercise {
        return exercises[currentExerciseIndex]
    }
}
