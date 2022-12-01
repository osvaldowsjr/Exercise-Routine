package com.schimidt.exerciseRoutine.providers.dataSource.remote

import com.schimidt.exerciseRoutine.BuildConfig
import com.schimidt.exerciseRoutine.model.dto.ExerciseDTO
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface WorkoutApi {
    @GET("exercises?")
    suspend fun getExercises(
        @Header("X-Api-Key")
        apiKey: String = BuildConfig.API_KEY,
        @Query("type")
        type: String? = null,
        @Query("muscle")
        muscle: String? = null,
        @Query("difficulty")
        diff: String? = null
    ): List<ExerciseDTO>
}