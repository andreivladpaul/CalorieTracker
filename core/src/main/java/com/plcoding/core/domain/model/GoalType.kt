package com.plcoding.core.domain.model

/**
 * Represents the goal of a person regarding their weight.
 * This is used to calculate the daily calorie needs.
 *
 * @property name The name of the goal type.
 */
sealed class GoalType(val name: String) {
    /**
     * Represents the goal to lose weight.
     */
    object LoseWeight: GoalType("lose_weight")

    /**
     * Represents the goal to keep the current weight.
     */
    object KeepWeight: GoalType("keep_weight")

    /**
     * Represents the goal to gain weight.
     */
    object GainWeight: GoalType("gain_weight")

    companion object {
        /**
         * Returns a [GoalType] from a string representation.
         *
         * @param name The string representation of the goal type.
         * @return The corresponding [GoalType], or [KeepWeight] if the string is not recognized.
         */
        fun fromString(name: String): GoalType {
            return when(name) {
                "lose_weight" -> LoseWeight
                "keep_weight" -> KeepWeight
                "gain_weight" -> GainWeight
                else -> KeepWeight
            }
        }
    }
}
