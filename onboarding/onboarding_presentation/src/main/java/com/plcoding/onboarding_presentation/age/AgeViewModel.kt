package com.plcoding.onboarding_presentation.age

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
 * A ViewModel for the age entry screen.
 * It handles the state and logic for entering the user's age.
 *
 * @param preferences The [Preferences] repository to save the user's age.
 * @param filterOutDigits The use case to filter out non-digit characters from the input.
 */
@HiltViewModel
class AgeViewModel @Inject constructor(
    private val preferences: Preferences,
    private val filterOutDigits: FilterOutDigits
): ViewModel() {

    /**
     * The current age value entered by the user.
     * It is a mutable state that can be observed by the UI.
     * The default value is "20".
     */
    var age by mutableStateOf("20")
        private set

    private val _uiEvent = Channel<UiEvent>()
    /**
     * A flow of [UiEvent]s that can be collected by the UI to react to one-time events,
     * such as showing a snackbar or navigating to the next screen.
     */
    val uiEvent = _uiEvent.receiveAsFlow()

    /**
     * Called when the user enters their age.
     * It filters out non-digit characters and updates the [age] state.
     * The age is limited to a maximum of 3 digits.
     *
     * @param age The age string entered by the user.
     */
    fun onAgeEnter(age: String) {
        if(age.length <= 3) {
            this.age = filterOutDigits(age)
        }
    }

    /**
     * Called when the user clicks the 'Next' button.
     * It validates the entered age, saves it to the preferences if valid,
     * and sends a [UiEvent.Success] to navigate to the next screen.
     * If the age is invalid, it sends a [UiEvent.ShowSnackbar] with an error message.
     */
    fun onNextClick() {
        viewModelScope.launch {
            val ageNumber = age.toIntOrNull() ?: kotlin.run {
                _uiEvent.send(
                    UiEvent.ShowSnackbar(
                        UiText.StringResource(R.string.error_age_cant_be_empty)
                    )
                )
                return@launch
            }
            preferences.saveAge(ageNumber)
            _uiEvent.send(UiEvent.Success)
        }
    }
}