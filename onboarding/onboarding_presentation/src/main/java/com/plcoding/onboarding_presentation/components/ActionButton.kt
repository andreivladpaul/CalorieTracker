package com.plcoding.onboarding_presentation.components

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import com.plcoding.core_ui.LocalSpacing

/**
 * A composable function that displays a styled action button.
 * This button is typically used for primary actions in the UI, such as 'Next' or 'Finish'.
 *
 * @param text The text to be displayed on the button.
 * @param onClick A callback that is invoked when the button is clicked.
 * @param modifier A [Modifier] to be applied to the button.
 * @param isEnabled A boolean indicating whether the button is enabled and can be clicked.
 * @param textStyle The [TextStyle] to be applied to the button's text.
 */
@Composable
fun ActionButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    isEnabled: Boolean = true,
    textStyle: TextStyle = MaterialTheme.typography.button
) {
    Button(
        onClick = onClick,
        modifier = modifier,
        enabled = isEnabled,
        shape = RoundedCornerShape(100.dp)
    ) {
        Text(
            text = text,
            style = textStyle,
            color = MaterialTheme.colors.onPrimary,
            modifier = Modifier.padding(LocalSpacing.current.spaceSmall)
        )
    }
}