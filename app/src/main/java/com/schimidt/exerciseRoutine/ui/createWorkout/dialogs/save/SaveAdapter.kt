package com.schimidt.exerciseRoutine.ui.createWorkout.dialogs.save

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.schimidt.exerciseRoutine.databinding.SaveExerciseItemBinding
import com.schimidt.exerciseRoutine.model.entity.Exercise
import com.schimidt.exerciseRoutine.utils.ExerciseComparator

class SaveAdapter :
    ListAdapter<Exercise, SaveViewHolder>(ExerciseComparator) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SaveViewHolder {
        val binding =
            SaveExerciseItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SaveViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SaveViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}