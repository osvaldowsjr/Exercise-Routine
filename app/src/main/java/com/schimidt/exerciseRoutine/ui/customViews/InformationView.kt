package com.schimidt.exerciseRoutine.ui.customViews

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import com.schimidt.exerciseRoutine.databinding.InformationLayoutBinding
import com.schimidt.exerciseRoutine.model.entity.Exercise

class InformationView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null
) : ConstraintLayout(context, attrs) {

    private lateinit var exercise: Exercise

    val binding = InformationLayoutBinding.inflate(LayoutInflater.from(context), this, true)

    init {
        binding.annotationButton.setOnClickListener {
            showAnnotation()
        }
        binding.infoText.setOnClickListener {
            showInstruction()
        }
    }

    fun setupExercise(exercise: Exercise) {
        this.exercise = exercise
        binding.infoText.text = exercise.instruction
    }

    private fun showInstruction() {
        binding.infoText.text = exercise.instruction
    }

    private fun showAnnotation() {
        binding.infoText.text = exercise.annotation
    }
}