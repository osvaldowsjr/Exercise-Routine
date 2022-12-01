package com.schimidt.exerciseRoutine.ui.home

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import androidx.core.view.MenuHost
import androidx.core.view.MenuProvider
import androidx.core.view.isVisible
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.LinearLayoutManager
import com.schimidt.exerciseRoutine.R
import com.schimidt.exerciseRoutine.databinding.HomeFragmentBinding
import com.schimidt.exerciseRoutine.model.entity.Workout
import com.schimidt.exerciseRoutine.ui.home.adapter.WorkoutAdapter
import com.schimidt.exerciseRoutine.ui.home.adapter.gesture.DragAndDropController
import com.schimidt.exerciseRoutine.ui.home.adapter.gesture.DragCallback
import com.schimidt.exerciseRoutine.ui.home.adapter.gesture.SwipeCallback
import com.schimidt.exerciseRoutine.ui.home.adapter.gesture.SwipeController
import com.schimidt.exerciseRoutine.utils.GenericFragment
import com.schimidt.exerciseRoutine.utils.viewBinding
import org.koin.androidx.viewmodel.ext.android.viewModel


class HomeFragment : GenericFragment(R.layout.home_fragment) {

    private val binding by viewBinding(HomeFragmentBinding::bind)
    private val homeViewModel by viewModel<HomeViewModel>()
    private val rvAdapter = WorkoutAdapter()
    private lateinit var dragHelper: DragAndDropController
    private lateinit var swipeHelper: SwipeController

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        createAdapterActions()
        setupViewModel()
        setupButtons()
    }

    private fun setupButtons() {
        binding.bottomNavBar.setFabAction {
            navigation.goFromHomeToCreation()
        }
    }

    private fun setupViewModel() {
        lifecycleScope.launchWhenCreated {
            homeViewModel.fetchWorkouts()
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                homeViewModel.workouts.observe(viewLifecycleOwner) {
                    binding.explanationText.isVisible = it.isNullOrEmpty()
                    binding.workoutList.isVisible = !it.isNullOrEmpty()
                    setupList(it)
                }
            }
        }
    }

    private fun setupList(workoutList: MutableList<Workout>) {
        rvAdapter.submitList(workoutList)
        dragHelper.callback.updateList(workoutList)
        swipeHelper.callback.updateList(workoutList)
    }

    private fun createAdapterActions() {
        val rvList = binding.workoutList
        swipeHelper =
            SwipeController(SwipeCallback(rvAdapter, resources, requireContext().theme) {})
        dragHelper = DragAndDropController(DragCallback(rvAdapter))

        swipeHelper.attachToRecyclerView(rvList)
        dragHelper.attachToRecyclerView(rvList)

        rvList.apply {
            adapter = rvAdapter
            layoutManager = LinearLayoutManager(requireContext())
        }
    }

}