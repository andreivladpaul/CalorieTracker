package com.plcoding.core.domain.model

/**
 * Represents the activity level of a person.
 * This is used to calculate the daily calorie needs.
 *
 * @property name The name of the activity level.
 */
sealed class ActivityLevel(val name: String) {
    /**
     * Represents a low activity level.
     */
    object Low: ActivityLevel("low")
    /**
     * Represents a medium activity level.
     */
    object Medium: ActivityLevel("medium")
    /**
     * Represents a high activity level.
     */
    object High: ActivityLevel("high")

    companion object {
        /**
         * Returns an [ActivityLevel] from a string representation.
         *
         * @param name The string representation of the activity level.
         * @return The corresponding [ActivityLevel], or [Medium] if the string is not recognized.
         */
        fun fromString(name: String): ActivityLevel {
            return when(name) {
                "low" -> Low
                "medium" -> Medium
                "high" -> High
                else -> Medium
            }
        }
    }
}
