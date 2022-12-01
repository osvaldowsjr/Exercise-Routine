package com.schimidt.exerciseRoutine.ui.createWorkout.adapter

import androidx.recyclerview.widget.DiffUtil
import com.schimidt.exerciseRoutine.model.entity.Exercise

object ExerciseComparator : DiffUtil.ItemCallback<Exercise>() {
    override fun areItemsTheSame(oldItem: Exercise, newItem: Exercise): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: Exercise, newItem: Exercise): Boolean {
        return areItemsTheSame(oldItem, newItem)
    }
}