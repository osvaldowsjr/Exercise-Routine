package com.schimidt.exerciseRoutine.ui.createWorkout.dialogs.save

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.navArgs
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.schimidt.exerciseRoutine.R
import com.schimidt.exerciseRoutine.databinding.SaveDialogBinding
import com.schimidt.exerciseRoutine.model.entity.Exercise
import com.schimidt.exerciseRoutine.utils.viewBinding

class SaveWorkoutDialog : BottomSheetDialogFragment(R.layout.save_dialog) {

    val binding by viewBinding(SaveDialogBinding::bind)
    val args: SaveWorkoutDialogArgs by navArgs()
    lateinit var exerciseList: MutableList<Exercise>

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        exerciseList = args.arrayOfExercise.toMutableList()
    }




}