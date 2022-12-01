package com.schimidt.exerciseRoutine.ui.createWorkout.adapter

import androidx.recyclerview.widget.RecyclerView
import com.schimidt.exerciseRoutine.databinding.ExerciseItemBinding
import com.schimidt.exerciseRoutine.model.entity.Exercise

class ExerciseViewHolder(private val binding: ExerciseItemBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(exercise: Exercise, dialogAction: (Exercise) -> Unit) {
        binding.exerciseName.text = exercise.name
        binding.equipmentNeeded.text = exercise.equip
        binding.materialButton.setOnClickListener {
            dialogAction(exercise)
        }
    }
}