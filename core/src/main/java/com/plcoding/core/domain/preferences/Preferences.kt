package com.plcoding.core.domain.preferences

import com.plcoding.core.domain.model.ActivityLevel
import com.plcoding.core.domain.model.Gender
import com.plcoding.core.domain.model.GoalType
import com.plcoding.core.domain.model.UserInfo

/**
 * An interface for saving and retrieving user-related data.
 * This acts as an abstraction over the data storage mechanism (e.g., SharedPreferences).
 */
interface Preferences {
    /**
     * Saves the user's gender.
     * @param gender The [Gender] to save.
     */
    fun saveGender(gender: Gender)

    /**
     * Saves the user's age.
     * @param age The age to save.
     */
    fun saveAge(age: Int)

    /**
     * Saves the user's weight.
     * @param weight The weight to save.
     */
    fun saveWeight(weight: Float)

    /**
     * Saves the user's height.
     * @param height The height to save.
     */
    fun saveHeight(height: Int)

    /**
     * Saves the user's activity level.
     * @param level The [ActivityLevel] to save.
     */
    fun saveActivityLevel(level: ActivityLevel)

    /**
     * Saves the user's goal type.
     * @param type The [GoalType] to save.
     */
    fun saveGoalType(type: GoalType)

    /**
     * Saves the user's desired carbohydrate ratio.
     * @param ratio The carbohydrate ratio to save.
     */
    fun saveCarbRatio(ratio: Float)

    /**
     * Saves the user's desired protein ratio.
     * @param ratio The protein ratio to save.
     */
    fun saveProteinRatio(ratio: Float)

    /**
     * Saves the user's desired fat ratio.
     * @param ratio The fat ratio to save.
     */
    fun saveFatRatio(ratio: Float)

    /**
     * Loads the user's information.
     * @return A [UserInfo] object containing all the user's saved information.
     */
    fun loadUserInfo(): UserInfo

    /**
     * Saves whether the onboarding process should be shown.
     * @param shouldShow True if onboarding should be shown, false otherwise.
     */
    fun saveShouldShowOnboarding(shouldShow: Boolean)

    /**
     * Loads the flag indicating whether the onboarding process should be shown.
     * @return True if onboarding should be shown, false otherwise.
     */
    fun loadShouldShowOnboarding(): Boolean

    /**
     * A companion object holding the keys for the preferences.
     */
    companion object {
        const val KEY_GENDER = "gender"
        const val KEY_AGE = "age"
        const val KEY_WEIGHT = "weight"
        const val KEY_HEIGHT = "height"
        const val KEY_ACTIVITY_LEVEL = "activity_level"
        const val KEY_GOAL_TYPE = "goal_type"
        const val KEY_CARB_RATIO = "carb_ratio"
        const val KEY_PROTEIN_RATIO = "protein_ratio"
        const val KEY_FAT_RATIO = "fat_ratio"
        const val KEY_SHOULD_SHOW_ONBOARDING = "should_show_onboarding"
    }
}