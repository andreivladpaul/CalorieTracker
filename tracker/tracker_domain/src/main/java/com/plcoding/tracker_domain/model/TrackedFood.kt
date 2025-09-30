package com.plcoding.tracker_domain.model

import java.time.LocalDate

/**
 * Represents a food item that has been tracked by the user for a specific meal.
 *
 * @property name The name of the food.
 * @property carbs The amount of carbohydrates in grams for the tracked amount.
 * @property protein The amount of protein in grams for the tracked amount.
 * @property fat The amount of fat in grams for the tracked amount.
 * @property imageUrl The URL of an image of the food, if available.
 * @property mealType The type of meal this food was tracked for (e.g., breakfast, lunch).
 * @property amount The amount of the food in grams that was tracked.
 * @property date The date on which the food was tracked.
 * @property calories The number of calories for the tracked amount.
 * @property id The unique identifier of the tracked food item in the local database.
 */
data class TrackedFood(
    val name: String,
    val carbs: Int,
    val protein: Int,
    val fat: Int,
    val imageUrl: String?,
    val mealType: MealType,
    val amount: Int,
    val date: LocalDate,
    val calories: Int,
    val id: Int? = null
)
