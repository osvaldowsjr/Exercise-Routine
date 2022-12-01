package com.schimidt.exerciseRoutine.providers.dataSource

import com.schimidt.exerciseRoutine.model.entity.Exercise
import com.schimidt.exerciseRoutine.model.entity.Workout
import com.schimidt.exerciseRoutine.model.mapper.toExercise
import com.schimidt.exerciseRoutine.providers.dataSource.local.WorkoutDao
import com.schimidt.exerciseRoutine.providers.dataSource.remote.WorkoutApi

class WorkoutDataSourceImpl(
    private val workoutDao: WorkoutDao, private val workoutApi: WorkoutApi
) : WorkoutDataSource {
    override suspend fun fetchWorkouts(): List<Workout> {
        return workoutDao.getAllWorkouts()
    }

    override suspend fun fetchExercises(
        type: String?,
        muscle: String?,
        diff: String?
    ): List<Exercise> {
        val listOfExercise: MutableList<Exercise> = mutableListOf()
        val response = workoutApi.getExercises(
            type = type,
            muscle = muscle,
            diff = diff
        )
        response.forEach {
            listOfExercise.add(it.toExercise())
        }
        return listOfExercise
    }

    override suspend fun saveWorkout(workout: Workout) {
        workoutDao.insert(workout)
    }

    override suspend fun updateWorkout(workout: Workout) {
        workoutDao.updateWorkout(workout)
    }
}