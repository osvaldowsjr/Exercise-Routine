package com.schimidt.exerciseRoutine.utils

object MuscleGroup {
    fun provideMuscleGroupList(): Array<out String> {
        return arrayOf(
            "",
            "Abdominais",
            "Abdutores",
            "Adutores",
            "Bíceps",
            "Panturrilha",
            "Peito",
            "Antebraços",
            "Glúteos",
            "Flexores",
            "Dorsais",
            "Lombar",
            "Meio das costas",
            "Pescoço",
            "Quadríceps",
            "Trapézios",
            "Tríceps",
        )
    }

    fun getTranslation(ptString: String): String {
        return when (ptString) {
            "Abdominais" -> "abdominals"
            "Abdutores" -> "abductors"
            "Adutores" -> "adductors"
            "Bíceps" -> "biceps"
            "Panturrilha" -> "calves"
            "Peito" -> "chest"
            "Antebraços" -> "forearms"
            "Glúteos" -> "glutes"
            "Flexores" -> "hamstrings"
            "Dorsais" -> "lats"
            "Lombar" -> "lower_back"
            "Meio das costas" -> "middle_back"
            "Pescoço" -> "neck"
            "Quadríceps" -> "quadriceps"
            "Trapézios" -> "traps"
            "Tríceps" -> "triceps"
            else -> ""
        }

    }
}