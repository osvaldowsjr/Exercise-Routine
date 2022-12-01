package com.schimidt.exerciseRoutine.providers.repo

import com.schimidt.exerciseRoutine.model.entity.Exercise
import com.schimidt.exerciseRoutine.model.entity.Workout

interface WorkoutRepository {
    suspend fun fetchWorkouts(): List<Workout>
    suspend fun fetchExercises(
        type: String? = null, muscle: String? = null, diff: String? = null
    ): List<Exercise>

    suspend fun saveWorkout(
        workoutName: String,
        listOfExercise: List<Exercise>
    )

    suspend fun updateWorkout()
}