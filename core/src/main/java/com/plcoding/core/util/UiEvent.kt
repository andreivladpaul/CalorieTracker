package com.plcoding.core.util

/**
 * A sealed class representing UI events that can be sent from ViewModels to the UI.
 */
sealed class UiEvent {
    /**
     * Represents a successful event.
     */
    object Success: UiEvent()

    /**
     * Represents a navigate up event.
     */
    object NavigateUp: UiEvent()

    /**
     * Represents an event to show a snackbar.
     *
     * @param message The message to be displayed in the snackbar.
     */
    data class ShowSnackbar(val message: UiText): UiEvent()
}
