package com.schimidt.exerciseRoutine.model.mapper

import com.schimidt.exerciseRoutine.model.dto.ExerciseDTO
import com.schimidt.exerciseRoutine.model.entity.Exercise

fun Exercise.toExerciseDto(): ExerciseDTO {
    return ExerciseDTO(
        name, type, muscle, equip, diff, instruction
    )
}

fun ExerciseDTO.toExercise(): Exercise {
    return Exercise(
        name, type, muscle, equip, diff, instruction, "", "", ""
    )
}