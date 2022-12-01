package com.schimidt.exerciseRoutine.ui.createWorkout

import com.schimidt.exerciseRoutine.model.entity.Exercise

sealed class CreateWorkoutState {
    data class Success(val list: List<Exercise>) : CreateWorkoutState()
    object EmptySuccess : CreateWorkoutState()
    object Loading : CreateWorkoutState()
    object Waiting : CreateWorkoutState()
}