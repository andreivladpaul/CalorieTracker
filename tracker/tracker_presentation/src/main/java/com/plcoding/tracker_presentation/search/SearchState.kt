package com.plcoding.tracker_presentation.search

/**
 * Represents the state of the search screen.
 *
 * @property query The current search query entered by the user.
 * @property isHintVisible Whether the search query hint should be visible.
 * @property isSearching Whether a search is currently in progress.
 * @property trackableFood The list of food items that match the search query, wrapped in [TrackableFoodUiState].
 */
data class SearchState(
    val query: String = "",
    val isHintVisible: Boolean = false,
    val isSearching: Boolean = false,
    val trackableFood: List<TrackableFoodUiState> = emptyList()
)