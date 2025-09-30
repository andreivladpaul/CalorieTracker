package com.plcoding.tracker_presentation.tracker_overview

import com.plcoding.tracker_domain.model.TrackedFood

/**
 * Represents events that can be triggered from the tracker overview screen.
 */
sealed class TrackerOverviewEvent {
    /**
     * Event triggered when the user clicks the "next day" button.
     */
    object OnNextDayClick: TrackerOverviewEvent()
    /**
     * Event triggered when the user clicks the "previous day" button.
     */
    object OnPreviousDayClick: TrackerOverviewEvent()
    /**
     * Event triggered when the user expands or collapses a meal.
     * @param meal The [Meal] that was toggled.
     */
    data class OnToggleMealClick(val meal: Meal): TrackerOverviewEvent()
    /**
     * Event triggered when the user deletes a tracked food item.
     * @param trackedFood The [TrackedFood] to be deleted.
     */
    data class OnDeleteTrackedFoodClick(val trackedFood: TrackedFood): TrackerOverviewEvent()
}
