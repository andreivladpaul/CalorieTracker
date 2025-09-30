package com.plcoding.onboarding_presentation.nutrient_goal

/**
 * Represents events that can be triggered from the nutrient goal screen.
 */
sealed class NutrientGoalEvent {
    /**
     * Event triggered when the user enters a value for the carbohydrate ratio.
     * @param ratio The carbohydrate ratio as a string.
     */
    data class OnCarbRatioEnter(val ratio: String): NutrientGoalEvent()
    /**
     * Event triggered when the user enters a value for the protein ratio.
     * @param ratio The protein ratio as a string.
     */
    data class OnProteinRatioEnter(val ratio: String): NutrientGoalEvent()
    /**
     * Event triggered when the user enters a value for the fat ratio.
     * @param ratio The fat ratio as a string.
     */
    data class OnFatRatioEnter(val ratio: String): NutrientGoalEvent()
    /**
     * Event triggered when the user clicks the 'Next' button.
     */
    object OnNextClick: NutrientGoalEvent()
}
