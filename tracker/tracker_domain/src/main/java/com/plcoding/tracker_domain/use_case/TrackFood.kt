package com.plcoding.tracker_domain.use_case

import com.plcoding.tracker_domain.model.MealType
import com.plcoding.tracker_domain.model.TrackableFood
import com.plcoding.tracker_domain.model.TrackedFood
import com.plcoding.tracker_domain.repository.TrackerRepository
import java.time.LocalDate
import kotlin.math.roundToInt

/**
 * A use case for tracking a food item.
 * It calculates the nutrient values for a given amount of a food and saves it to the repository.
 *
 * @param repository The [TrackerRepository] to interact with the data source.
 */
class TrackFood(
    private val repository: TrackerRepository
) {

    /**
     * Tracks a food item by calculating its nutrients for the given amount and saving it.
     *
     * @param food The [TrackableFood] to be tracked.
     * @param amount The amount of the food in grams.
     * @param mealType The [MealType] for which the food is being tracked.
     * @param date The [LocalDate] for which the food is being tracked.
     */
    suspend operator fun invoke(
        food: TrackableFood,
        amount: Int,
        mealType: MealType,
        date: LocalDate
    ) {
        repository.insertTrackedFood(
            TrackedFood(
                name = food.name,
                carbs = ((food.carbsPer100g / 100f) * amount).roundToInt(),
                protein = ((food.proteinPer100g / 100f) * amount).roundToInt(),
                fat = ((food.fatPer100g / 100f) * amount).roundToInt(),
                calories = ((food.caloriesPer100g / 100f) * amount).roundToInt(),
                imageUrl = food.imageUrl,
                mealType = mealType,
                amount = amount,
                date = date,
            )
        )
    }
}