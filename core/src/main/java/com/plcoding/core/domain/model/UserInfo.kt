package com.plcoding.core.domain.model

/**
 * Represents the user's personal information.
 * This information is used to calculate the daily calorie and nutrient needs.
 *
 * @property gender The gender of the user.
 * @property age The age of the user in years.
 * @property weight The weight of the user in kilograms.
 * @property height The height of the user in centimeters.
 * @property activityLevel The activity level of the user.
 * @property goalType The weight goal of the user.
 * @property carbRatio The desired ratio of carbohydrates in the diet.
 * @property proteinRatio The desired ratio of protein in the diet.
 * @property fatRatio The desired ratio of fat in the diet.
 */
data class UserInfo(
    val gender: Gender,
    val age: Int,
    val weight: Float,
    val height: Int,
    val activityLevel: ActivityLevel,
    val goalType: GoalType,
    val carbRatio: Float,
    val proteinRatio: Float,
    val fatRatio: Float
)
