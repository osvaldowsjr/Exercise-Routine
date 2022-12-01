package com.schimidt.exerciseRoutine.model.converters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.schimidt.exerciseRoutine.model.entity.Exercise

class ExerciseConverter {
    private val gson = Gson()

    @TypeConverter
    fun stringToExerciseList(data: String): List<Exercise> {
        val listType = object : TypeToken<List<Exercise?>?>() {}.type
        return gson.fromJson(data, listType)
    }

    @TypeConverter
    fun exerciseListToString(list: List<Exercise>): String {
        return gson.toJson(list)
    }
}