package com.schimidt.exerciseRoutine.providers.dataSource

import com.schimidt.exerciseRoutine.model.entity.Exercise
import com.schimidt.exerciseRoutine.model.entity.Workout

interface WorkoutDataSource {
    suspend fun fetchWorkouts(): List<Workout>
    suspend fun fetchExercises(
        type: String? = null, muscle: String? = null, diff: String? = null
    ): List<Exercise>
    suspend fun saveWorkout(workout: Workout)
    suspend fun updateWorkout(workout: Workout)
}