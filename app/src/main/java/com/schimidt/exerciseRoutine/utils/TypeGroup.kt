package com.schimidt.exerciseRoutine.utils

object TypeGroup {
    fun provideTypeList(): Array<out String> {
        return arrayOf(
            "",
            "Cardio",
            "Levantamento de peso olímpico",
            "Pliometria",
            "Levantamento de peso",
            "Força",
            "Alongamento",
            "Strongman",
        )
    }

    fun getTranslation(ptString: String): String {
        return when (ptString) {
            "Cardio" -> "cardio"
            "Levantamento de peso olímpico" -> "olympic_weightlifting"
            "Pliometria" -> "plyometrics"
            "Levantamento de peso" -> "powerlifting"
            "Força" -> "strength"
            "Alongamento" -> "stretching"
            "Strongman" -> "strongman"
            else -> ""
        }
    }
}