package com.plcoding.tracker_domain.use_case

/**
 * A wrapper class that holds all the use cases for the tracker domain.
 * This is useful for injecting all use cases at once.
 *
 * @property trackFood The use case for tracking a food item.
 * @property searchFood The use case for searching for food.
 * @property getFoodsForDate The use case for getting foods for a specific date.
 * @property deleteTrackedFood The use case for deleting a tracked food item.
 * @property calculateMealNutrients The use case for calculating the nutrient totals for a list of tracked foods.
 */
data class TrackerUseCases(
    val trackFood: TrackFood,
    val searchFood: SearchFood,
    val getFoodsForDate: GetFoodsForDate,
    val deleteTrackedFood: DeleteTrackedFood,
    val calculateMealNutrients: CalculateMealNutrients
)
