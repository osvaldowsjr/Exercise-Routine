package com.schimidt.exerciseRoutine.utils

import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.schimidt.exerciseRoutine.model.entity.Exercise

fun Fragment.getNavigationResult(key: String = "exercise") =
    findNavController().currentBackStackEntry?.savedStateHandle?.getLiveData<Exercise>(key)

fun Fragment.setNavigationResult(result: Exercise, key: String = "exercise") {
    findNavController().previousBackStackEntry?.savedStateHandle?.set(key, result)
}