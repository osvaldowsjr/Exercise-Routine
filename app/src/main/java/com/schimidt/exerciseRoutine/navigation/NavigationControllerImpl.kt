package com.schimidt.exerciseRoutine.navigation

import androidx.navigation.NavController
import com.schimidt.exerciseRoutine.model.entity.Exercise
import com.schimidt.exerciseRoutine.ui.createWorkout.CreationFragmentDirections
import com.schimidt.exerciseRoutine.ui.home.HomeFragmentDirections

class NavigationControllerImpl(
    private val navController: NavController
) : NavigationController {
    override fun goFromHomeToCreation() {
        navController.navigate(HomeFragmentDirections.actionHomeFragmentToCreationFragment())
    }

    override fun openExerciseAddingDialog(exercise: Exercise) {
        val action =
            CreationFragmentDirections.actionCreationFragmentToExerciseAddingDialog(exercise)
        navController.navigate(action)
    }

    override fun openSaveWorkoutDialog(list: MutableList<Exercise>) {
        val action =
            CreationFragmentDirections.actionCreationFragmentToSaveWorkoutDialog(list.toTypedArray())
        navController.navigate(action)
    }
}