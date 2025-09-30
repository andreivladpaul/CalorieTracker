package com.plcoding.onboarding_presentation.weight

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.plcoding.core.domain.preferences.Preferences
import com.plcoding.core.util.UiEvent
import com.plcoding.core.util.UiText
import com.plcoding.onboarding_presentation.R
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * A ViewModel for the weight entry screen.
 * It handles the state and logic for entering the user's weight.
 *
 * @param preferences The [Preferences] repository to save the user's weight.
 */
@HiltViewModel
class WeightViewModel @Inject constructor(
    private val preferences: Preferences,
): ViewModel() {

    /**
     * The current weight value entered by the user.
     * It is a mutable state that can be observed by the UI.
     * The default value is "80.0".
     */
    var weight by mutableStateOf("80.0")
        private set

    private val _uiEvent = Channel<UiEvent>()
    /**
     * A flow of [UiEvent]s that can be collected by the UI to react to one-time events,
     * such as showing a snackbar or navigating to the next screen.
     */
    val uiEvent = _uiEvent.receiveAsFlow()

    /**
     * Called when the user enters their weight.
     * It updates the [weight] state.
     * The weight is limited to a maximum of 5 characters.
     *
     * @param weight The weight string entered by the user.
     */
    fun onWeightEnter(weight: String) {
        if(weight.length <= 5) {
            this.weight = weight
        }
    }

    /**
     * Called when the user clicks the 'Next' button.
     * It validates the entered weight, saves it to the preferences if valid,
     * and sends a [UiEvent.Success] to navigate to the next screen.
     * If the weight is invalid, it sends a [UiEvent.ShowSnackbar] with an error message.
     */
    fun onNextClick() {
        viewModelScope.launch {
            val weightNumber = weight.toFloatOrNull() ?: kotlin.run {
                _uiEvent.send(
                    UiEvent.ShowSnackbar(
                        UiText.StringResource(R.string.error_weight_cant_be_empty)
                    )
                )
                return@launch
            }
            preferences.saveWeight(weightNumber)
            _uiEvent.send(UiEvent.Success)
        }
    }
}