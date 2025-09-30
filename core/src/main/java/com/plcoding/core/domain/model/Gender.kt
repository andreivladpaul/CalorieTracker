package com.plcoding.core.domain.model

/**
 * Represents the gender of a person.
 * This is used to calculate the daily calorie needs.
 *
 * @property name The name of the gender.
 */
sealed class Gender(val name: String) {
    /**
     * Represents the male gender.
     */
    object Male: Gender("male")

    /**
     * Represents the female gender.
     */
    object Female: Gender("female")

    companion object {
        /**
         * Returns a [Gender] from a string representation.
         *
         * @param name The string representation of the gender.
         * @return The corresponding [Gender], or [Female] if the string is not recognized.
         */
        fun fromString(name: String): Gender {
            return when(name) {
                "male" -> Male
                "female" -> Female
                else -> Female
            }
        }
    }
}
