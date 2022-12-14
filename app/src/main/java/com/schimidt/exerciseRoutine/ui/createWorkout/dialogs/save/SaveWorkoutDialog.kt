package com.schimidt.exerciseRoutine.ui.createWorkout.dialogs.save

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.schimidt.exerciseRoutine.R
import com.schimidt.exerciseRoutine.databinding.SaveDialogBinding
import com.schimidt.exerciseRoutine.model.entity.Exercise
import com.schimidt.exerciseRoutine.utils.viewBinding

class SaveWorkoutDialog : BottomSheetDialogFragment(R.layout.save_dialog) {

    private val binding by viewBinding(SaveDialogBinding::bind)
    private val args: SaveWorkoutDialogArgs by navArgs()
    private val saveAdapter = SaveAdapter()
    private lateinit var exerciseList: MutableList<Exercise>

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        exerciseList = args.arrayOfExercise.toMutableList()
        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        saveAdapter.submitList(exerciseList)
        binding.exerciseRv.apply {
            adapter = saveAdapter
            layoutManager = LinearLayoutManager(requireContext())
        }
    }


}