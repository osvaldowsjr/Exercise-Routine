package com.schimidt.exerciseRoutine.providers.repo

import com.schimidt.exerciseRoutine.model.entity.Exercise
import com.schimidt.exerciseRoutine.model.entity.Workout
import com.schimidt.exerciseRoutine.providers.dataSource.WorkoutDataSource
import kotlinx.coroutines.withContext
import kotlin.coroutines.CoroutineContext

class WorkoutRepositoryImpl(
    private val dataSource: WorkoutDataSource,
    private val coroutineContext: CoroutineContext
) : WorkoutRepository {
    override suspend fun fetchWorkouts(): List<Workout> = withContext(coroutineContext) {
        dataSource.fetchWorkouts()
    }

    override suspend fun fetchExercises(
        type: String?,
        muscle: String?,
        diff: String?
    ): List<Exercise> = withContext(coroutineContext) {
        dataSource.fetchExercises(type, muscle, diff)
    }

    override suspend fun saveWorkout(
        workoutName: String,
        listOfExercise: List<Exercise>
    ) = withContext(coroutineContext) {
        val workout = Workout(
            workoutName = workoutName,
            listOfExercise = listOfExercise
        )
        dataSource.saveWorkout(workout)
    }

    override suspend fun updateWorkout() = withContext(coroutineContext) {

    }
}