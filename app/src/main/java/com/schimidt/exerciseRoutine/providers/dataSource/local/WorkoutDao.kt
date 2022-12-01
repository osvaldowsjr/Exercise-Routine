package com.schimidt.exerciseRoutine.providers.dataSource.local

import androidx.room.*
import com.schimidt.exerciseRoutine.model.entity.Workout

@Dao
interface WorkoutDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(workout: Workout)

    @Update
    suspend fun updateWorkout(workout: Workout)

    @Query("SELECT * FROM workoutTable")
    fun getAllWorkouts(): List<Workout>
}