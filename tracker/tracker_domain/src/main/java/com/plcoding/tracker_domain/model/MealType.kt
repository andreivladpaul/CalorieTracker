package com.plcoding.tracker_domain.model

/**
 * Represents the type of a meal.
 *
 * @property name The name of the meal type.
 */
sealed class MealType(val name: String) {
    /**
     * Represents the breakfast meal.
     */
    object Breakfast: MealType("breakfast")
    /**
     * Represents the lunch meal.
     */
    object Lunch: MealType("lunch")
    /**
     * Represents the dinner meal.
     */
    object Dinner: MealType("dinner")
    /**
     * Represents a snack.
     */
    object Snack: MealType("snack")

    companion object {
        /**
         * Returns a [MealType] from a string representation.
         *
         * @param name The string representation of the meal type.
         * @return The corresponding [MealType], or [Breakfast] if the string is not recognized.
         */
        fun fromString(name: String): MealType {
            return when(name) {
                "breakfast" -> Breakfast
                "lunch" -> Lunch
                "dinner" -> Dinner
                "snack" -> Snack
                else -> Breakfast
            }
        }
    }
}
