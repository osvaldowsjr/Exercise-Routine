package com.schimidt.exerciseRoutine.ui.createWorkout

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.schimidt.exerciseRoutine.model.entity.Exercise
import com.schimidt.exerciseRoutine.providers.repo.WorkoutRepository
import com.schimidt.exerciseRoutine.utils.DiffGroup
import com.schimidt.exerciseRoutine.utils.MuscleGroup
import com.schimidt.exerciseRoutine.utils.TypeGroup
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class CreationViewModel(private val repository: WorkoutRepository) : ViewModel() {

    private val _uiState: MutableStateFlow<CreateWorkoutState> =
        MutableStateFlow(CreateWorkoutState.Waiting)
    val uiState: StateFlow<CreateWorkoutState> = _uiState
    val listOfExercise: MutableList<Exercise> = mutableListOf()

    fun getExerciseList(
        type: String,
        muscle: String,
        diff: String
    ) = viewModelScope.launch {
        _uiState.value = CreateWorkoutState.Loading
        val result = repository.fetchExercises(
            type = TypeGroup.getTranslation(type),
            muscle = MuscleGroup.getTranslation(muscle),
            diff = DiffGroup.getTranslation(diff)
        )

        if (result.isEmpty())
            _uiState.value = CreateWorkoutState.EmptySuccess
        else
            _uiState.value = CreateWorkoutState.Success(result)
    }
}