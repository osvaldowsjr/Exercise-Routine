package com.schimidt.exerciseRoutine.model.dto

import com.google.gson.annotations.SerializedName

data class ExerciseDTO(
    @SerializedName("name")
    val name: String,
    @SerializedName("type")
    val type: String,
    @SerializedName("muscle")
    val muscle: String,
    @SerializedName("equipment")
    val equip: String,
    @SerializedName("difficulty")
    val diff: String,
    @SerializedName("instructions")
    val instruction: String
)