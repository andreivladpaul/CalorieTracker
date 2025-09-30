package com.plcoding.onboarding_presentation.height

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.plcoding.core.domain.preferences.Preferences
import com.plcoding.core.domain.use_case.FilterOutDigits
import com.plcoding.core.util.UiEvent
import com.plcoding.core.util.UiText
import com.plcoding.onboarding_presentation.R
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * A ViewModel for the height entry screen.
 * It handles the state and logic for entering the user's height.
 *
 * @param preferences The [Preferences] repository to save the user's height.
 * @param filterOutDigits The use case to filter out non-digit characters from the input.
 */
@HiltViewModel
class HeightViewModel @Inject constructor(
    private val preferences: Preferences,
    private val filterOutDigits: FilterOutDigits
): ViewModel() {

    /**
     * The current height value entered by the user.
     * It is a mutable state that can be observed by the UI.
     * The default value is "180".
     */
    var height by mutableStateOf("180")
        private set

    private val _uiEvent = Channel<UiEvent>()
    /**
     * A flow of [UiEvent]s that can be collected by the UI to react to one-time events,
     * such as showing a snackbar or navigating to the next screen.
     */
    val uiEvent = _uiEvent.receiveAsFlow()

    /**
     * Called when the user enters their height.
     * It filters out non-digit characters and updates the [height] state.
     * The height is limited to a maximum of 3 digits.
     *
     * @param height The height string entered by the user.
     */
    fun onHeightEnter(height: String) {
        if(height.length <= 3) {
            this.height = filterOutDigits(height)
        }
    }

    /**
     * Called when the user clicks the 'Next' button.
     * It validates the entered height, saves it to the preferences if valid,
     * and sends a [UiEvent.Success] to navigate to the next screen.
     * If the height is invalid, it sends a [UiEvent.ShowSnackbar] with an error message.
     */
    fun onNextClick() {
        viewModelScope.launch {
            val heightNumber = height.toIntOrNull() ?: kotlin.run {
                _uiEvent.send(
                    UiEvent.ShowSnackbar(
                        UiText.StringResource(R.string.error_height_cant_be_empty)
                    )
                )
                return@launch
            }
            preferences.saveHeight(heightNumber)
            _uiEvent.send(UiEvent.Success)
        }
    }
}