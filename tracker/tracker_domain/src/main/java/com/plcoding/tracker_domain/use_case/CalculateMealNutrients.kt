package com.plcoding.tracker_domain.use_case

import com.plcoding.core.domain.model.ActivityLevel
import com.plcoding.core.domain.model.Gender
import com.plcoding.core.domain.model.GoalType
import com.plcoding.core.domain.model.UserInfo
import com.plcoding.core.domain.preferences.Preferences
import com.plcoding.tracker_domain.model.MealType
import com.plcoding.tracker_domain.model.TrackedFood
import kotlin.math.roundToInt

/**
 * A use case for calculating the nutrient totals for a list of tracked foods,
 * as well as the user's daily nutrient goals.
 *
 * @param preferences The [Preferences] repository to load user information from.
 */
class CalculateMealNutrients(
    private val preferences: Preferences
) {

    /**
     * Calculates the nutrient totals for the given list of tracked foods and the user's daily goals.
     *
     * @param trackedFoods The list of [TrackedFood] items for a specific day.
     * @return A [Result] object containing the calculated nutrient information and goals.
     */
    operator fun invoke(trackedFoods: List<TrackedFood>): Result {
        val allNutrients = trackedFoods
            .groupBy { it.mealType }
            .mapValues { entry ->
                val type = entry.key
                val foods = entry.value
                MealNutrients(
                    carbs = foods.sumOf { it.carbs },
                    protein = foods.sumOf { it.protein },
                    fat = foods.sumOf { it.fat },
                    calories = foods.sumOf { it.calories },
                    mealType = type
                )
            }
        val totalCarbs = allNutrients.values.sumOf { it.carbs }
        val totalProtein = allNutrients.values.sumOf { it.protein }
        val totalFat = allNutrients.values.sumOf { it.fat }
        val totalCalories = allNutrients.values.sumOf { it.calories }

        val userInfo = preferences.loadUserInfo()
        val caloryGoal = dailyCaloryRequirement(userInfo)
        val carbsGoal = (caloryGoal * userInfo.carbRatio / 4f).roundToInt()
        val proteinGoal = (caloryGoal * userInfo.proteinRatio / 4f).roundToInt()
        val fatGoal = (caloryGoal * userInfo.fatRatio / 9f).roundToInt()

        return Result(
            carbsGoal = carbsGoal,
            proteinGoal = proteinGoal,
            fatGoal = fatGoal,
            caloriesGoal = caloryGoal,
            totalCarbs = totalCarbs,
            totalProtein = totalProtein,
            totalFat = totalFat,
            totalCalories = totalCalories,
            mealNutrients = allNutrients
        )
    }

    private fun bmr(userInfo: UserInfo): Int {
        return when(userInfo.gender) {
            is Gender.Male -> {
                (66.47f + 13.75f * userInfo.weight +
                        5f * userInfo.height - 6.75f * userInfo.age).roundToInt()
            }
            is Gender.Female ->  {
                (665.09f + 9.56f * userInfo.weight +
                        1.84f * userInfo.height - 4.67 * userInfo.age).roundToInt()
            }
        }
    }

    private fun dailyCaloryRequirement(userInfo: UserInfo): Int {
        val activityFactor = when(userInfo.activityLevel) {
            is ActivityLevel.Low -> 1.2f
            is ActivityLevel.Medium -> 1.3f
            is ActivityLevel.High -> 1.4f
        }
        val caloryExtra = when(userInfo.goalType) {
            is GoalType.LoseWeight -> -500
            is GoalType.KeepWeight -> 0
            is GoalType.GainWeight -> 500
        }
        return (bmr(userInfo) * activityFactor + caloryExtra).roundToInt()
    }

    /**
     * Represents the nutrient totals for a specific meal.
     *
     * @property carbs The total carbohydrates for the meal.
     * @property protein The total protein for the meal.
     * @property fat The total fat for the meal.
     * @property calories The total calories for the meal.
     * @property mealType The type of the meal.
     */
    data class MealNutrients(
        val carbs: Int,
        val protein: Int,
        val fat: Int,
        val calories: Int,
        val mealType: MealType
    )

    /**
     * Represents the result of the nutrient calculation, including goals and totals.
     *
     * @property carbsGoal The daily goal for carbohydrates in grams.
     * @property proteinGoal The daily goal for protein in grams.
     * @property fatGoal The daily goal for fat in grams.
     * @property caloriesGoal The daily goal for calories.
     * @property totalCarbs The total consumed carbohydrates for the day in grams.
     * @property totalProtein The total consumed protein for the day in grams.
     * @property totalFat The total consumed fat for the day in grams.
     * @property totalCalories The total consumed calories for the day.
     * @property mealNutrients A map of [MealType] to [MealNutrients] containing the nutrient totals for each meal.
     */
    data class Result(
        val carbsGoal: Int,
        val proteinGoal: Int,
        val fatGoal: Int,
        val caloriesGoal: Int,
        val totalCarbs: Int,
        val totalProtein: Int,
        val totalFat: Int,
        val totalCalories: Int,
        val mealNutrients: Map<MealType, MealNutrients>
    )
}