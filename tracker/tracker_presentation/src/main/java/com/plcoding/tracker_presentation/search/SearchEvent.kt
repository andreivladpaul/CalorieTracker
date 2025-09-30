package com.plcoding.tracker_presentation.search

import com.plcoding.tracker_domain.model.MealType
import com.plcoding.tracker_domain.model.TrackableFood
import java.time.LocalDate

/**
 * Represents events that can be triggered from the search screen.
 */
sealed class SearchEvent {
    /**
     * Event triggered when the search query changes.
     * @param query The new search query.
     */
    data class OnQueryChange(val query: String) : SearchEvent()
    /**
     * Event triggered when the user initiates a search.
     */
    object OnSearch : SearchEvent()
    /**
     * Event triggered when the user expands or collapses a trackable food item.
     * @param food The [TrackableFood] item that was toggled.
     */
    data class OnToggleTrackableFood(val food: TrackableFood) : SearchEvent()
    /**
     * Event triggered when the user changes the amount for a trackable food.
     * @param food The [TrackableFood] for which the amount is being changed.
     * @param amount The new amount as a string.
     */
    data class OnAmountForFoodChange(
        val food: TrackableFood,
        val amount: String
    ) : SearchEvent()
    /**
     * Event triggered when the user clicks the "Track" button for a food item.
     * @param food The [TrackableFood] to be tracked.
     * @param mealType The [MealType] to track the food as.
     * @param date The [LocalDate] for which to track the food.
     */
    data class OnTrackFoodClick(
        val food: TrackableFood,
        val mealType: MealType,
        val date: LocalDate
    ): SearchEvent()
    /**
     * Event triggered when the search text field gains or loses focus.
     * @param isFocused True if the text field is focused, false otherwise.
     */
    data class OnSearchFocusChange(val isFocused: Boolean): SearchEvent()
}
