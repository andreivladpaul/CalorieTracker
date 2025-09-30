package com.plcoding.onboarding_presentation.goal

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.plcoding.core.domain.model.GoalType
import com.plcoding.core.domain.preferences.Preferences
import com.plcoding.core.util.UiEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * A ViewModel for the goal selection screen.
 * It handles the state and logic for selecting a weight goal.
 *
 * @param preferences The [Preferences] repository to save the selected goal type.
 */
@HiltViewModel
class GoalViewModel @Inject constructor(
    private val preferences: Preferences
): ViewModel() {

    /**
     * The currently selected goal type.
     * It is a mutable state that can be observed by the UI.
     * The default value is [GoalType.KeepWeight].
     */
    var selectedGoal by mutableStateOf<GoalType>(
        GoalType.KeepWeight
    )
        private set

    private val _uiEvent = Channel<UiEvent>()
    /**
     * A flow of [UiEvent]s that can be collected by the UI to react to one-time events,
     * such as navigating to the next screen.
     */
    val uiEvent = _uiEvent.receiveAsFlow()

    /**
     * Called when the user selects a goal type.
     * Updates the [selectedGoal] state.
     *
     * @param goalType The [GoalType] that was selected.
     */
    fun onGoalTypeSelect(goalType: GoalType) {
        selectedGoal = goalType
    }

    /**
     * Called when the user clicks the 'Next' button.
     * Saves the selected goal type to the preferences and sends a [UiEvent.Success] to navigate to the next screen.
     */
    fun onNextClick() {
        viewModelScope.launch {
            preferences.saveGoalType(selectedGoal)
            _uiEvent.send(UiEvent.Success)
        }
    }
}