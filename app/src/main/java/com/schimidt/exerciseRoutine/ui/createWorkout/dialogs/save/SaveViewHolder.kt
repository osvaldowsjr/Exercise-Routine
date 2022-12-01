package com.schimidt.exerciseRoutine.ui.createWorkout.dialogs.save

import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.schimidt.exerciseRoutine.R
import com.schimidt.exerciseRoutine.databinding.SaveExerciseItemBinding
import com.schimidt.exerciseRoutine.model.entity.Exercise
import com.schimidt.exerciseRoutine.ui.customViews.InformationView

class SaveViewHolder(val binding: SaveExerciseItemBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(exercise: Exercise) {
        val context = binding.root.context
        val repsString = context.getString(R.string.reps_placeholder, exercise.reps)
        val seriesString = context.getString(R.string.series_placeholder, exercise.series)
        val weightString = context.getString(R.string.weight_placeholder, exercise.weight)
        binding.name.text = exercise.name
        binding.repsLabel.text = repsString
        binding.seriesLabel.text = seriesString
        binding.weightLabel.text = weightString

        MaterialAlertDialogBuilder(context)
            .setView(InformationView(context))
            .show()
    }
}