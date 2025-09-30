package com.plcoding.onboarding_presentation.gender

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.plcoding.core.domain.model.Gender
import com.plcoding.core.domain.preferences.Preferences
import com.plcoding.core.util.UiEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * A ViewModel for the gender selection screen.
 * It handles the state and logic for selecting a gender.
 *
 * @param preferences The [Preferences] repository to save the selected gender.
 */
@HiltViewModel
class GenderViewModel @Inject constructor(
    private val preferences: Preferences
): ViewModel() {

    /**
     * The currently selected gender.
     * It is a mutable state that can be observed by the UI.
     * The default value is [Gender.Male].
     */
    var selectedGender by mutableStateOf<Gender>(Gender.Male)
        private set

    private val _uiEvent = Channel<UiEvent>()
    /**
     * A flow of [UiEvent]s that can be collected by the UI to react to one-time events,
     * such as navigating to the next screen.
     */
    val uiEvent = _uiEvent.receiveAsFlow()

    /**
     * Called when the user selects a gender.
     * Updates the [selectedGender] state.
     *
     * @param gender The [Gender] that was selected.
     */
    fun onGenderClick(gender: Gender) {
        selectedGender = gender
    }

    /**
     * Called when the user clicks the 'Next' button.
     * Saves the selected gender to the preferences and sends a [UiEvent.Success] to navigate to the next screen.
     */
    fun onNextClick() {
        viewModelScope.launch {
            preferences.saveGender(selectedGender)
            _uiEvent.send(UiEvent.Success)
        }
    }
}