package com.schimidt.exerciseRoutine.ui.home.adapter

import androidx.recyclerview.widget.RecyclerView
import com.schimidt.exerciseRoutine.databinding.WorkoutItemBinding
import com.schimidt.exerciseRoutine.model.entity.Workout

class WorkoutViewHolder(private val binding: WorkoutItemBinding) :
    RecyclerView.ViewHolder(binding.root) {
    var workout: Workout? = null

    fun bind(workout: Workout) {
        this.workout = workout
        binding.workout = workout

        binding.minusButton.setOnClickListener {
            var number = binding.editText.text.toString().toInt()
            if (number > 0) number -= 1
            binding.editText.text = number.toString()
        }

        binding.plusButton.setOnClickListener {
            var number = binding.editText.text.toString().toInt()
            number += 1
            binding.editText.text = number.toString()
        }
    }
}