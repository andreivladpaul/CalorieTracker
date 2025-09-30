package com.plcoding.onboarding_presentation.nutrient_goal

/**
 * Represents the state of the nutrient goal screen.
 *
 * @property carbsRatio The string representation of the carbohydrate ratio.
 * @property proteinRatio The string representation of the protein ratio.
 * @property fatRatio The string representation of the fat ratio.
 */
data class NutrientGoalState(
    val carbsRatio: String = "40",
    val proteinRatio: String = "30",
    val fatRatio: String = "30"
)
