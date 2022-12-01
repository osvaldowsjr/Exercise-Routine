package com.schimidt.exerciseRoutine.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.schimidt.exerciseRoutine.model.entity.Workout
import com.schimidt.exerciseRoutine.providers.repo.WorkoutRepository
import kotlinx.coroutines.launch

class HomeViewModel(private val repository: WorkoutRepository) : ViewModel() {

    private val _workouts: MutableLiveData<MutableList<Workout>> = MutableLiveData()
    val workouts: LiveData<MutableList<Workout>> = _workouts

    fun fetchWorkouts() = viewModelScope.launch {
        //_workouts.value = repository.fetchWorkouts() as MutableList<Workout>
        _workouts.value =
            mutableListOf(
                Workout(
                    workoutName = "A", listOfExercise = mutableListOf()
                ),
                Workout(
                    workoutName = "B", listOfExercise = mutableListOf()
                ),
                Workout(
                    workoutName = "C", listOfExercise = mutableListOf()
                )
                ,
                Workout(
                    workoutName = "D", listOfExercise = mutableListOf()
                )
            )
    }
}