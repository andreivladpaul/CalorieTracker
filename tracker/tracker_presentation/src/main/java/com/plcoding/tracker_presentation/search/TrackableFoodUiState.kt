package com.plcoding.tracker_presentation.search

import com.plcoding.tracker_domain.model.TrackableFood

/**
 * Represents the UI state for a single trackable food item in the search results.
 * It wraps a [TrackableFood] domain model and adds UI-specific properties.
 *
 * @property food The [TrackableFood] item from the domain layer.
 * @property isExpanded Whether the UI for this item is expanded to show more details (like the amount input).
 * @property amount The amount of the food entered by the user, as a string.
 */
data class TrackableFoodUiState(
    val food: TrackableFood,
    val isExpanded: Boolean = false,
    val amount: String = ""
)
