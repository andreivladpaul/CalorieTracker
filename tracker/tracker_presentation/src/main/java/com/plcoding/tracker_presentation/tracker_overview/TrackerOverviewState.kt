package com.plcoding.tracker_presentation.tracker_overview

import com.plcoding.tracker_domain.model.TrackedFood
import java.time.LocalDate

/**
 * Represents the state of the tracker overview screen.
 *
 * @property totalCarbs The total carbohydrates consumed on the selected date.
 * @property totalProtein The total protein consumed on the selected date.
 * @property totalFat The total fat consumed on the selected date.
 * @property totalCalories The total calories consumed on the selected date.
 * @property carbsGoal The daily goal for carbohydrates.
 * @property proteinGoal The daily goal for protein.
 * @property fatGoal The daily goal for fat.
 * @property caloriesGoal The daily goal for calories.
 * @property date The currently selected date.
 * @property trackedFoods The list of food items tracked for the selected date.
 * @property meals The list of meals for the selected date, including their nutrient totals and UI state.
 */
data class TrackerOverviewState(
    val totalCarbs: Int = 0,
    val totalProtein: Int = 0,
    val totalFat: Int = 0,
    val totalCalories: Int = 0,
    val carbsGoal: Int = 0,
    val proteinGoal: Int = 0,
    val fatGoal: Int = 0,
    val caloriesGoal: Int = 0,
    val date: LocalDate = LocalDate.now(),
    val trackedFoods: List<TrackedFood> = emptyList(),
    val meals: List<Meal> = defaultMeals
)
