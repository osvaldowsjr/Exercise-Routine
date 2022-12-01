package com.schimidt.exerciseRoutine.ui.home.adapter

import androidx.recyclerview.widget.DiffUtil
import com.schimidt.exerciseRoutine.model.entity.Workout

object WorkoutComparator : DiffUtil.ItemCallback<Workout>() {
    override fun areItemsTheSame(oldItem: Workout, newItem: Workout): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: Workout, newItem: Workout): Boolean {
        return areItemsTheSame(oldItem, newItem)
    }
}