package com.schimidt.exerciseRoutine.ui.createWorkout.dialogs

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.navArgs
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.schimidt.exerciseRoutine.R
import com.schimidt.exerciseRoutine.databinding.ExerciseAddingDialogBinding
import com.schimidt.exerciseRoutine.model.entity.Exercise
import com.schimidt.exerciseRoutine.utils.setNavigationResult
import com.schimidt.exerciseRoutine.utils.viewBinding

class ExerciseAddingDialog : BottomSheetDialogFragment(R.layout.exercise_adding_dialog) {

    val binding by viewBinding(ExerciseAddingDialogBinding::bind)
    private val args: ExerciseAddingDialogArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupButtons()
        setupTexts()
    }

    private fun setupTexts() {
        val exercise = args.exercise
        binding.apply {
            name.setText(exercise.name)
            type.setText(exercise.type)
            weight.setText(exercise.weight)
            instruction.setText(exercise.instruction)
            equip.setText(exercise.equip)
            annotation.setText(exercise.annotation)
            muscle.setText(exercise.muscle)
            diff.setText(exercise.diff)
            series.setText(exercise.series)
        }
    }

    private fun setupButtons() {
        binding.close.setOnClickListener {
            dialog?.dismiss()
        }

        binding.saveButton.setOnClickListener {
            setNavigationResult(
                Exercise(
                    binding.name.text.toString(),
                    binding.type.text.toString(),
                    binding.muscle.text.toString(),
                    binding.equip.text.toString(),
                    binding.diff.text.toString(),
                    binding.instruction.text.toString(),
                    binding.annotation.text.toString(),
                    binding.reps.text.toString(),
                    binding.weight.text.toString(),
                    binding.series.text.toString()
                )
            )
            dialog?.dismiss()
        }
    }

}