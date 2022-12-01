package com.schimidt.exerciseRoutine.ui.createWorkout.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.schimidt.exerciseRoutine.databinding.ExerciseItemBinding
import com.schimidt.exerciseRoutine.model.entity.Exercise

class ExerciseAdapter(private val dialogAction: (Exercise) -> Unit) :
    ListAdapter<Exercise, ExerciseViewHolder>(ExerciseComparator) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExerciseViewHolder {
        val binding =
            ExerciseItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ExerciseViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ExerciseViewHolder, position: Int) {
        holder.bind(getItem(position),dialogAction)
    }
}