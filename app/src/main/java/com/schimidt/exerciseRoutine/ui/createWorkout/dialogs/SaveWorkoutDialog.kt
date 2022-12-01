package com.schimidt.exerciseRoutine.ui.createWorkout.dialogs

import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.schimidt.exerciseRoutine.R
import com.schimidt.exerciseRoutine.databinding.SaveDialogBinding
import com.schimidt.exerciseRoutine.utils.viewBinding

class SaveWorkoutDialog : BottomSheetDialogFragment(R.layout.save_dialog) {

    val binding by viewBinding(SaveDialogBinding::bind)


}