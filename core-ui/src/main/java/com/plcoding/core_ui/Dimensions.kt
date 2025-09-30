package com.plcoding.core_ui

import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

/**
 * A data class that holds dimension values for spacing in the UI.
 * This allows for consistent spacing throughout the application.
 *
 * @property default The default spacing, which is 0dp.
 * @property spaceExtraSmall An extra small spacing value (4dp).
 * @property spaceSmall A small spacing value (8dp).
 * @property spaceMedium A medium spacing value (16dp).
 * @property spaceLarge A large spacing value (32dp).
 * @property spaceExtraLarge An extra large spacing value (64dp).
 */
data class Dimensions(
    val default: Dp = 0.dp,
    val spaceExtraSmall: Dp = 4.dp,
    val spaceSmall: Dp = 8.dp,
    val spaceMedium: Dp = 16.dp,
    val spaceLarge: Dp = 32.dp,
    val spaceExtraLarge: Dp = 64.dp
)

/**
 * A CompositionLocal that provides the [Dimensions] for the current composition.
 * This can be used to access the spacing values from any composable function.
 */
val LocalSpacing = compositionLocalOf { Dimensions() }
