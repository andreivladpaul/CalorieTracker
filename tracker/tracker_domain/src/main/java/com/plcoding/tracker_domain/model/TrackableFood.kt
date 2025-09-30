package com.plcoding.tracker_domain.model

/**
 * Represents a food item that can be tracked.
 * This is typically the result of a food search from a remote API.
 *
 * @property name The name of the food.
 * @property imageUrl The URL of an image of the food, if available.
 * @property caloriesPer100g The number of calories per 100g of the food.
 * @property carbsPer100g The amount of carbohydrates in grams per 100g of the food.
 * @property proteinPer100g The amount of protein in grams per 100g of the food.
 * @property fatPer100g The amount of fat in grams per 100g of the food.
 */
data class TrackableFood(
    val name: String,
    val imageUrl: String?,
    val caloriesPer100g: Int,
    val carbsPer100g: Int,
    val proteinPer100g: Int,
    val fatPer100g: Int
)
