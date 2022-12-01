package com.schimidt.exerciseRoutine.model.entity

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity
data class Exercise(
    @PrimaryKey
    val name: String,
    val type: String,
    val muscle: String,
    val equip: String,
    val diff: String,
    val instruction: String,
    var annotation: String,
    var reps: String,
    var weight: String,
    var series: String
) : Parcelable {
    override fun equals(other: Any?): Boolean {
        return this.name == (other as Exercise).name
    }

    override fun hashCode(): Int {
        return name.hashCode() * 31
    }
}