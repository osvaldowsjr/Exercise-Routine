package com.schimidt.exerciseRoutine.providers.dataSource.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.schimidt.exerciseRoutine.model.converters.ExerciseConverter
import com.schimidt.exerciseRoutine.model.entity.Workout

@Database(
    entities = [Workout::class],
    version = 1,
    exportSchema = true,
)
@TypeConverters(ExerciseConverter::class)
abstract class WorkoutDatabase : RoomDatabase() {
    abstract val workoutDao: WorkoutDao

    companion object {
        @Volatile
        private var INSTANCE: WorkoutDao? = null

        fun getDao(
            context: Context,
        ): WorkoutDao {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    WorkoutDatabase::class.java,
                    "workout_database"
                ).build().workoutDao
                INSTANCE = instance
                instance
            }
        }

    }
}