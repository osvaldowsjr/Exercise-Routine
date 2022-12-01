package com.schimidt.exerciseRoutine.utils

object DiffGroup {
    fun provideDiffList(): Array<out String> {
        return arrayOf(
            "",
            "Iniciante",
            "Intermediário",
            "Experiente",
        )
    }

    fun getTranslation(ptString: String): String {
        return when (ptString) {
            "Iniciante" -> "beginner"
            "Intermediário" -> "intermediate"
            "Experiente" -> "expert"
            else -> ""
        }
    }
}