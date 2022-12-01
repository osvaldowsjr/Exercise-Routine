package com.schimidt.exerciseRoutine.ui.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.schimidt.exerciseRoutine.databinding.WorkoutItemBinding
import com.schimidt.exerciseRoutine.model.entity.Workout

class WorkoutAdapter : ListAdapter<Workout, WorkoutViewHolder>(WorkoutComparator) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WorkoutViewHolder {
        val binding = WorkoutItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return WorkoutViewHolder(binding)
    }

    override fun onBindViewHolder(holder: WorkoutViewHolder, position: Int) {
        holder.bind(currentList[position])
    }
}