package com.plcoding.onboarding_domain.use_case

import com.plcoding.core.util.UiText
import com.plcoding.onboarding_domain.R

/**
 * A use case for validating the nutrient goal inputs.
 * It checks if the provided carbohydrate, protein, and fat ratios are valid integers
 * and if their sum is equal to 100.
 */
class ValidateNutrients {

    /**
     * Validates the nutrient ratio strings.
     *
     * @param carbsRatioText The string representation of the carbohydrate ratio.
     * @param proteinRatioText The string representation of the protein ratio.
     * @param fatRatioText The string representation of the fat ratio.
     * @return A [Result] object which is either [Result.Success] containing the parsed ratios as floats,
     * or [Result.Error] containing an error message.
     */
    operator fun invoke(
        carbsRatioText: String,
        proteinRatioText: String,
        fatRatioText: String
    ): Result {
        val carbsRatio = carbsRatioText.toIntOrNull()
        val proteinRatio = proteinRatioText.toIntOrNull()
        val fatRatio = fatRatioText.toIntOrNull()
        if(carbsRatio == null || proteinRatio == null || fatRatio == null) {
            return Result.Error(
                message = UiText.StringResource(R.string.error_invalid_values)
            )
        }
        if(carbsRatio + proteinRatio + fatRatio != 100) {
            return Result.Error(
                message = UiText.StringResource(R.string.error_not_100_percent)
            )
        }
        return Result.Success(
            carbsRatio / 100f,
            proteinRatio / 100f,
            fatRatio / 100f
        )
    }

    /**
     * Represents the result of the nutrient validation.
     * It can be either a success or an error.
     */
    sealed class Result {
        /**
         * Represents a successful validation.
         *
         * @property carbsRatio The validated and converted carbohydrate ratio (e.g., 0.4f for 40%).
         * @property proteinRatio The validated and converted protein ratio (e.g., 0.3f for 30%).
         * @property fatRatio The validated and converted fat ratio (e.g., 0.3f for 30%).
         */
        data class Success(
            val carbsRatio: Float,
            val proteinRatio: Float,
            val fatRatio: Float
        ): Result()
        /**
         * Represents a failed validation.
         *
         * @property message The error message to be displayed to the user.
         */
        data class Error(val message: UiText): Result()
    }
}