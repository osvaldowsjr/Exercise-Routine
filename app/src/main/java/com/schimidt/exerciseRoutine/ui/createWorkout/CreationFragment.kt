package com.schimidt.exerciseRoutine.ui.createWorkout

import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.textfield.MaterialAutoCompleteTextView
import com.schimidt.exerciseRoutine.R
import com.schimidt.exerciseRoutine.databinding.CreationFragmentBinding
import com.schimidt.exerciseRoutine.model.entity.Exercise
import com.schimidt.exerciseRoutine.ui.createWorkout.adapter.ExerciseAdapter
import com.schimidt.exerciseRoutine.utils.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class CreationFragment : GenericFragment(R.layout.creation_fragment) {

    private val binding by viewBinding(CreationFragmentBinding::bind)
    private val creationViewModel by viewModel<CreationViewModel>()
    private val exerciseAdapter = ExerciseAdapter { exercise ->
        openDialog(exercise)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupSpinners()
        setupBottomBar()
        setupViewModel()
        setupRecyclerView()
    }

    override fun onStart() {
        super.onStart()
        getNavigationResult()?.observe(viewLifecycleOwner) {
            creationViewModel.listOfExercise.add(it)
            binding.bottomNavBar.updateBadgeNumber(creationViewModel.listOfExercise.size)
        }
    }

    private fun openDialog(exercise: Exercise) {
        navigation.openExerciseAddingDialog(exercise)
    }

    private fun setupRecyclerView() {
        binding.exerciseRv.apply {
            adapter = exerciseAdapter
            layoutManager = LinearLayoutManager(requireContext())
        }
    }

    private fun setupViewModel() {
        lifecycleScope.launchWhenCreated {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                creationViewModel.uiState.collect { uiState ->
                    when (uiState) {
                        CreateWorkoutState.EmptySuccess -> dealEmpty()
                        CreateWorkoutState.Loading -> startLoading()
                        CreateWorkoutState.Waiting -> dealWaiting()
                        is CreateWorkoutState.Success -> dealSuccess(uiState.list)
                    }
                }
            }
        }
    }

    private fun dealWaiting() {
        binding.waitingLayout.isVisible = true
        binding.emptyLayout.isVisible = false
        binding.exerciseRv.isVisible = false
        binding.loading.isVisible = false
    }

    private fun dealSuccess(list: List<Exercise>) {
        exerciseAdapter.submitList(list)
        binding.waitingLayout.isVisible = false
        binding.emptyLayout.isVisible = false
        binding.exerciseRv.isVisible = true
        binding.loading.isVisible = false
    }

    private fun startLoading() {
        binding.waitingLayout.isVisible = false
        binding.emptyLayout.isVisible = false
        binding.exerciseRv.isVisible = false
        binding.loading.isVisible = true
    }

    private fun dealEmpty() {
        binding.waitingLayout.isVisible = false
        binding.emptyLayout.isVisible = true
        binding.exerciseRv.isVisible = false
        binding.loading.isVisible = false
    }

    private fun setupBottomBar() {
        binding.bottomNavBar.setBadgeOnEndIcon()
        binding.bottomNavBar.setFabIcon(
            ContextCompat.getDrawable(
                requireContext(),
                R.drawable.icon_search
            )
        )

        binding.bottomNavBar.setFabAction {
            creationViewModel.getExerciseList(
                binding.typeSpinner.text.toString(),
                binding.bodySpinner.text.toString(),
                binding.diffSpinner.text.toString()
            )
        }
        binding.bottomNavBar.setEndIcon(
            ContextCompat.getDrawable(
                requireContext(),
                R.drawable.icon_save
            )
        )
        binding.bottomNavBar.binding.bottomNav.setOnMenuItemClickListener { menuItem ->
            when (menuItem.itemId) {
                R.id.workout -> {
                    navigation.openSaveWorkoutDialog(creationViewModel.listOfExercise)
                    true
                }
                else -> false
            }
        }
    }

    private fun setupSpinners() {
        (binding.bodySpinner as? MaterialAutoCompleteTextView)
            ?.setSimpleItems(MuscleGroup.provideMuscleGroupList())
        (binding.typeSpinner as? MaterialAutoCompleteTextView)
            ?.setSimpleItems(TypeGroup.provideTypeList())
        (binding.diffSpinner as? MaterialAutoCompleteTextView)
            ?.setSimpleItems(DiffGroup.provideDiffList())
    }
}