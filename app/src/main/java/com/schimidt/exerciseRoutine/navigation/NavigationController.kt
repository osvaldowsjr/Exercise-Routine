package com.schimidt.exerciseRoutine.navigation

import com.schimidt.exerciseRoutine.model.entity.Exercise

interface NavigationController {
    fun goFromHomeToCreation()
    fun openExerciseAddingDialog(exercise: Exercise)
    fun openSaveWorkoutDialog(list: MutableList<Exercise>)
}