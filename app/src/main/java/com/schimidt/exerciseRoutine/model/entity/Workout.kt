package com.schimidt.exerciseRoutine.model.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "workoutTable")
data class Workout(
    @PrimaryKey(autoGenerate = true)
    val workoutId: Int? = null,
    var workoutName: String,
    var amountOfTimesDone: Int = 0,
    var listOfExercise: List<Exercise>
)