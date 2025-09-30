package com.plcoding.tracker_data.mapper

import com.plcoding.tracker_data.local.entity.TrackedFoodEntity
import com.plcoding.tracker_domain.model.MealType
import com.plcoding.tracker_domain.model.TrackedFood
import java.time.LocalDate

/**
 * Converts a [TrackedFoodEntity] from the database to a [TrackedFood] domain model.
 *
 * @receiver The [TrackedFoodEntity] to be converted.
 * @return The corresponding [TrackedFood] object.
 */
fun TrackedFoodEntity.toTrackedFood(): TrackedFood {
    return TrackedFood(
        name = name,
        carbs = carbs,
        protein = protein,
        fat = fat,
        imageUrl = imageUrl,
        mealType = MealType.fromString(type),
        amount = amount,
        date = LocalDate.of(year, month, dayOfMonth),
        calories = calories,
        id = id
    )
}

/**
 * Converts a [TrackedFood] domain model to a [TrackedFoodEntity] for database storage.
 *
 * @receiver The [TrackedFood] to be converted.
 * @return The corresponding [TrackedFoodEntity] object.
 */
fun TrackedFood.toTrackedFoodEntity(): TrackedFoodEntity {
    return TrackedFoodEntity(
        name = name,
        carbs = carbs,
        protein = protein,
        fat = fat,
        imageUrl = imageUrl,
        type = mealType.name,
        amount = amount,
        dayOfMonth = date.dayOfMonth,
        month = date.monthValue,
        year = date.year,
        calories = calories,
        id = id
    )
}