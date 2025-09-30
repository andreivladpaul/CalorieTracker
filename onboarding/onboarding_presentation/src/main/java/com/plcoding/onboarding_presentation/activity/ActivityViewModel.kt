package com.plcoding.onboarding_presentation.activity

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.plcoding.core.domain.model.ActivityLevel
import com.plcoding.core.domain.preferences.Preferences
import com.plcoding.core.util.UiEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * A ViewModel for the activity selection screen.
 * It handles the state and logic for selecting an activity level.
 *
 * @param preferences The [Preferences] repository to save the selected activity level.
 */
@HiltViewModel
class ActivityViewModel @Inject constructor(
    private val preferences: Preferences
): ViewModel() {

    /**
     * The currently selected activity level.
     * It is a mutable state that can be observed by the UI.
     * The default value is [ActivityLevel.Medium].
     */
    var selectedActivityLevel by mutableStateOf<ActivityLevel>(
        ActivityLevel.Medium
    )
        private set

    private val _uiEvent = Channel<UiEvent>()
    /**
     * A flow of [UiEvent]s that can be collected by the UI to react to one-time events.
     */
    val uiEvent = _uiEvent.receiveAsFlow()

    /**
     * Called when the user selects an activity level.
     * Updates the [selectedActivityLevel] state.
     *
     * @param activityLevel The [ActivityLevel] that was selected.
     */
    fun onActivityLevelSelect(activityLevel: ActivityLevel) {
        selectedActivityLevel = activityLevel
    }

    /**
     * Called when the user clicks the 'Next' button.
     * Saves the selected activity level to the preferences and sends a [UiEvent.Success] to navigate to the next screen.
     */
    fun onNextClick() {
        viewModelScope.launch {
            preferences.saveActivityLevel(selectedActivityLevel)
            _uiEvent.send(UiEvent.Success)
        }
    }
}